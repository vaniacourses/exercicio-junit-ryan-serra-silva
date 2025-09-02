package calculadora;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

    @DisplayName("Deve retornar um número negativo quando somamos dois numeros negativos")
    @Test
    void test1(){
        int expected = -12;
        Assertions.assertEquals(expected, calc.soma(-4,-8));
    }

    @DisplayName("Deve retornar 5 quando a soma for feita por 8 e -3")
    @Test
    void test2(){
        int expected = 5;
        assertEquals(expected, calc.soma(8,-3));
    }
    @DisplayName("Deve retornar 0 quando houver multiplicação por zero")
    @Test
    void test3(){
        int expected = 0;
        assertEquals(expected, calc.multiplicacao(10,0));
    }
    @DisplayName("Deve retornar 10 quando os numeros a serem multiplicados serem 2 e 5")
    @Test
    void test4(){
        int expected = 10;
        assertEquals(expected,calc.multiplicacao(2,5));
    }

    @DisplayName("Deve retornar um número positivo quando dois números negativos forem multiplicados")
    @Test
    void test5(){
       int expected=4;
       assertEquals(expected, calc.multiplicacao(-2,-2));
       assertTrue(calc.ehPositivo(calc.multiplicacao(-2,-2)));
    }

    @DisplayName("Deve retornar um número negativo quando um numero positivo e outro negativo forem multiplicados")
    @Test
    void test6(){
        int expected=-3;
        assertEquals(expected, calc.multiplicacao(-1,3));
        assertFalse(calc.ehPositivo(calc.multiplicacao(-1,3)));
    }

    @DisplayName("Deve retornar verdadeiro quando o numero for positivo")
    @Test
    void test7(){
        assertTrue(calc.ehPositivo(3));
    }
    @DisplayName("Deve retornar falso quando o numero for negativo")
    @Test
    void test8(){
        assertFalse(calc.ehPositivo(-1));
    }

    @DisplayName("Deve retornar 5 quando o n for igual a 3")
    @Test
    void test9(){
        int expected=6;
        assertEquals(expected,calc.somatoria(3));
    }

    @DisplayName("Deve retornar 0 quando o numero for 0")
    @Test
    void test10(){
        int expected=0;
        assertEquals(expected,calc.somatoria(0));
    }

    @DisplayName("Deve retornar 0 quando o numero for negativo")
    @Test
    void test11(){
        int expected=0;
        assertEquals(expected,calc.somatoria(0));
    }

    @DisplayName("Deve retornar 0 quando os numeros forem iguais")
    @Test
    void test12(){
        int expected=0;
        assertEquals(expected, calc.compara(1,1));
    }

    @Test
    void test13(){
        int expected = 1;
        assertEquals(expected, calc.compara(2,1));
    }

    @Test
    void test14(){
        int expected =-1;
        assertEquals(expected, calc.compara(1,2));
    }


}
