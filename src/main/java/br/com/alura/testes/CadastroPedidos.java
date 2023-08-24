package br.com.alura.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ClienteDao;
import br.com.alura.dao.PedidoDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.ItemPedido;
import br.com.alura.modelo.Pedido;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroPedidos {
    public static void main(String[] agrs){
        popularBancoDeDados();

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(1l);

        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = clienteDao.buscarPorId(1l);

        em.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(1, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();
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
