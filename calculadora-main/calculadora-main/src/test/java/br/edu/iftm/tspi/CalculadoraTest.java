package br.edu.iftm.tspi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    private static Calculadora calc;

    @BeforeAll
    static void inicializarTeste() {
        System.out.println("Iniciando teste...");
    }

    @BeforeEach
    void instanciarObjetos() {
        calc = new Calculadora(3);
    }

    @Test
    void testConstrutorSemParametro() {
        Calculadora calc = new Calculadora();
        assertEquals(0, calc.getMemoria());
    }

    @Test
    void testConstrutorComParametro() {
        assertEquals(3, calc.getMemoria());
    }

    @Test
    void testSomarNumeroNegativo() {
        calc.somar(-2);
        assertEquals(1, calc.getMemoria());
    }

    @Test
    void testSubtrairNumeroPositivo() {
        calc.subtrair(2);
        assertEquals(1, calc.getMemoria());
    }

    @Test
    void testMultiplicarNumeroPositivo() {
        calc.multiplicar(2);
        assertEquals(6, calc.getMemoria());
    }

    @Test
    void testDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.dividir(0));
    }

    @Test
    void testDividirPorNumeroPositivo() throws Exception {
        calc.dividir(2);
        assertEquals(1, calc.getMemoria());
    }

    @Test
    void testExponenciarPorUm() throws Exception {
        calc.exponenciar(1);
        assertEquals(3, calc.getMemoria());
    }

    @Test
    void testExponenciarComValorMaiorQue10() {
        assertThrows(IllegalArgumentException.class, () -> calc.exponenciar(11));
    }

    @Test
    void testZerarMemoria() {
        calc.zerarMemoria();
        assertEquals(0, calc.getMemoria());
    }

    @AfterEach
    void finalizarCadaMetodoTeste() {
        System.out.println("Finalizando caso de teste");
    }

    @AfterAll
    static void finalizarTeste() {
        System.out.println("Fim do teste!!!");
    }
}
