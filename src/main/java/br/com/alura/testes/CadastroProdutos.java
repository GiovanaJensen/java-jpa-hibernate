package br.com.alura.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroProdutos {

    public static void main(String[] args){
        Categoria celulares = new Categoria("celulares");
        Produto celular = new Produto("xiomi redmi", "muito legal", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
