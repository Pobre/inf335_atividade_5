package br.unicamp.ic.inf335.beans;

import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnuncianteBeanTest {

    @Test
    @DisplayName("Teste adicionar um anuncio")
    void testAddOneAnuncio() {
        AnuncianteBean ab = new AnuncianteBean();
        AnuncioBean an = new AnuncioBean();
        ab.addAnuncio(an);

        assertEquals(1, ab.getAnuncios().size());
    }

    @Test
    @DisplayName("Teste remover um anuncio")
    void testRemoveOneAnuncio() {
        AnuncianteBean ab = new AnuncianteBean();
        AnuncioBean an = new AnuncioBean();
        ab.addAnuncio(an);

        assertEquals(1, ab.getAnuncios().size());

        ab.removeAnuncio(0);
        assertEquals(0, ab.getAnuncios().size());
    }

    @Test
    @DisplayName("Teste média de valores sem desconto")
    void testMediaDeValoresSemDesconto() {
        AnuncianteBean ab = new AnuncianteBean();
        AnuncioBean an1 = new AnuncioBean();
        an1.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an1.getProduto().setValor(2.0);
        AnuncioBean an2 = new AnuncioBean();
        an1.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an2.getProduto().setValor(2.0);
        AnuncioBean an3 = new AnuncioBean();
        an3.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an3.getProduto().setValor(2.0);

        ab.addAnuncio(an1);
        ab.addAnuncio(an2);
        ab.addAnuncio(an3);

        assertEquals(2.0, ab.valorMedioAnuncios());
    }

    @Test
    @DisplayName("Teste média de valores com 10% desconto")
    void testMediaDeValoresComDesconto() {
        AnuncianteBean ab = new AnuncianteBean();
        AnuncioBean an1 = new AnuncioBean();
        an1.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an1.getProduto().setValor(2.0);
        AnuncioBean an2 = new AnuncioBean();
        an1.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an2.getProduto().setValor(2.0);
        AnuncioBean an3 = new AnuncioBean();
        an3.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an3.getProduto().setValor(2.0);

        ab.addAnuncio(an1);
        ab.addAnuncio(an2);
        ab.addAnuncio(an3);

        for (AnuncioBean an : ab.getAnuncios()) {
            an.setDesconto(0.1);
        }

        assertEquals(1.8, ab.valorMedioAnuncios());
    }

    @Test
    @DisplayName("Teste média de valores com 0% desconto")
    void testMediaDeValoresComDescontoZero() {
        AnuncianteBean ab = new AnuncianteBean();
        AnuncioBean an1 = new AnuncioBean();
        an1.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an1.getProduto().setValor(2.0);
        AnuncioBean an2 = new AnuncioBean();
        an1.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an2.getProduto().setValor(2.0);
        AnuncioBean an3 = new AnuncioBean();
        an3.setProduto(new ProdutoBean("1", "1", "1", 2.0, "ativo"));
        an3.getProduto().setValor(2.0);

        ab.addAnuncio(an1);
        ab.addAnuncio(an2);
        ab.addAnuncio(an3);

        for (AnuncioBean an : ab.getAnuncios()) {
            an.setDesconto(0.0);
        }

        assertEquals(2.0, ab.valorMedioAnuncios());
    }
}