package br.com.alura.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ClienteDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class TesteCriteria {
    public static void main(String[] args) throws Exception {
        popularBancoDeDados();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        produtoDao.buscarPorParametrosComCriteria("celulares", null, LocalDate.now());
    }

    public static void popularBancoDeDados(){
        Categoria celulares = new Categoria("celulares");
        Categoria notebooks = new Categoria("notebooks");
        Produto celular = new Produto("xiomi redmi", "muito legal", new BigDecimal("800"), celulares);
        Produto notebook = new Produto("acer asus", "muito legal", new BigDecimal("3000"), notebooks);
        Cliente cliente = new  Cliente("Giovana", "1269164961");
        
        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        categoriaDao.cadastrar(notebooks);
        produtoDao.cadastrar(notebook);
        clienteDao.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
