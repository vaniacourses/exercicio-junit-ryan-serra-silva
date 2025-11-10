package jokenpo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testEmpates() {
        assertEquals(0, main.jogar(1, 1));
        assertEquals(0, main.jogar(2, 2));
        assertEquals(0, main.jogar(3, 3));
    }

    @Test
    void testVitoriaJogador1() {
        assertEquals(1, main.jogar(1, 2));
        assertEquals(1, main.jogar(2, 3));
        assertEquals(1, main.jogar(3, 1));
    }

    @Test
    void testVitoriaJogador2() {
        assertEquals(2, main.jogar(2, 1));
        assertEquals(2, main.jogar(3, 2));
        assertEquals(2, main.jogar(1, 3));
    }

    @Test
    void testEntradasInvalidas() {
        assertEquals(-1, main.jogar(0, 1));
        assertEquals(-1, main.jogar(4, 2));
        assertEquals(-1, main.jogar(2, -1));
        assertEquals(-1, main.jogar(10, 10));
    }
}
