package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    void setup() {
        carrinho = new Carrinho();
    }

    @Test
    void deveAdicionarItemEAumentarQuantidade() {
        Produto p = new Produto("Mouse", 50.0);
        carrinho.addItem(p);

        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void deveCalcularValorTotalCorretamente() {
        carrinho.addItem(new Produto("Mouse", 50.0));
        carrinho.addItem(new Produto("Teclado", 120.0));

        assertEquals(170.0, carrinho.getValorTotal());
    }

    @Test
    void deveRemoverItemExistente() throws ProdutoNaoEncontradoException {
        Produto p = new Produto("Mouse", 50.0);
        carrinho.addItem(p);

        carrinho.removeItem(p);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void deveLancarExcecaoAoRemoverItemInexistente() {
        Produto p = new Produto("Mouse", 50.0);

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(p);
        });
    }

    @Test
    void deveEsvaziarCarrinho() {
        carrinho.addItem(new Produto("Mouse", 50.0));
        carrinho.addItem(new Produto("Teclado", 120.0));

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
    }
}
