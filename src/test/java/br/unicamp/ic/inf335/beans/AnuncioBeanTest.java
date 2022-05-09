package br.unicamp.ic.inf335.beans;


import br.unicamp.ic.inf335.beans.AnuncioBean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class AnuncioBeanTest {

    // getValor de Anuncio não é padrão, a RN desta função é
    // retornar o valor calculado com desconto, então vamos
    // testar se está tudo OK e se o valor é calculado corretamente
    @Test
    void testGetValorIsDouble() {
        AnuncioBean an = new AnuncioBean();

        assertInstanceOf(Double.class, an.getValor());
    }

    @Test
    void testValorComDesconto() {
        AnuncioBean an = new AnuncioBean();
        an.getProduto().setValor(100.0);
        an.setDesconto(0.5);

        assertEquals(50.0, an.getValor());
    }

    @Test
    void testValorSemDesconto() {
        AnuncioBean an = new AnuncioBean();
        an.getProduto().setValor(100.0);
        an.setDesconto(0.0);

        assertEquals(100.0, an.getValor());
    }
}