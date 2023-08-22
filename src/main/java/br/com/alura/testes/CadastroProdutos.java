package br.com.alura.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroProdutos {

    public static void main(String[] args){
        Produto celular = new Produto();
        celular.setNome("xiomi redmi");
        celular.setDescricao("muito legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
