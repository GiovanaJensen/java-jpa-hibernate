package br.com.alura.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.Vo.RelatorioDeVendasVo;
import br.com.alura.modelo.Pedido;


public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Pedido pedido){
        this.em.persist(pedido);
    }

    public BigDecimal valorTotal(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class)
        .getSingleResult();
    }

    public List<RelatorioDeVendasVo> relatorioDeVendas(){
        String jpql = "SELECT new br.com.alura.Vo.RelatorioDeVendasVo(produto.nome, SUM(item.quantidade), MAX(pedido.data)) FROM Pedido pedido JOIN pedido.itens item JOIN item.produto produto GROUP BY produto.nome ORDER BY item.quantidade DESC";
        return em.createQuery(jpql, RelatorioDeVendasVo.class)
        .getResultList();
    }

    public Pedido buscarPedidoComCliente(Long id){
        return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
        .setParameter("id", id)
        .getSingleResult();
    }
}
