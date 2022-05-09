package br.unicamp.ic.inf335.beans;

import br.unicamp.ic.inf335.beans.ProdutoBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBeanTest {

    @Test
    @DisplayName("Teste de ordem dos produtos")
    void testProdutoSort() {
        ProdutoBean p1 = new ProdutoBean();
        p1.setValor(1.0);
        ProdutoBean p2 = new ProdutoBean();
        p2.setValor(2.0);
        ProdutoBean p3 = new ProdutoBean();
        p3.setValor(3.0);

        ArrayList<ProdutoBean> alp = new ArrayList<>();
        alp.add(p3);
        alp.add(p2);
        alp.add(p1);

        assertEquals(alp.get(0), p3);

        Collections.sort(alp);

        assertEquals(alp.get(0), p1);
    }

    @Test
    @DisplayName("Teste de ordem dos produtos errado")
    void testProdutoSortErrado() {
        ProdutoBean p1 = new ProdutoBean();
        p1.setValor(1.0);
        ProdutoBean p2 = new ProdutoBean();
        p2.setValor(2.0);
        ProdutoBean p3 = new ProdutoBean();
        p3.setValor(3.0);

        ArrayList<ProdutoBean> alp = new ArrayList<>();
        alp.add(p3);
        alp.add(p2);
        alp.add(p1);

        assertEquals(alp.get(0), p3);

        Collections.sort(alp);

        assertNotEquals(alp.get(0), p3);
    }
}