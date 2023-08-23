package br.com.alura.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroProdutos {

    public static void main(String[] args){
        cadastroProdutos();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getNome());

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p2 -> System.out.println(p2.getNome()));

        List<Produto> produtoPorNome = produtoDao.buscarPorNome("acer asus");
        produtoPorNome.forEach(p2 -> System.out.println(p2.getNome()));

        List<Produto> produtoPorCategoria = produtoDao.buscarPorNomeDaCategoria("celulares");
        produtoPorCategoria.forEach(p2 -> System.out.println(p2.getNome()));

        BigDecimal precoPorNome = produtoDao.buscarPrecoDoProdutoPorNome("acer asus");
        System.out.println("Preco do produto: " + precoPorNome);
    }

    public static void cadastroProdutos(){
        Categoria celulares = new Categoria("celulares");
        Categoria notebooks = new Categoria("notebooks");
        Produto celular = new Produto("xiomi redmi", "muito legal", new BigDecimal("800"), celulares);
        Produto notebook = new Produto("acer asus", "muito legal", new BigDecimal("3000"), notebooks);
        
        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        categoriaDao.cadastrar(notebooks);
        produtoDao.cadastrar(notebook);
        em.getTransaction().commit();
        em.close();
    }
}
