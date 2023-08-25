package br.com.alura.Vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {
    // representa o relatorio

    private String nomeProduto;
    private Long quantidadeVendida;
    private LocalDate dataUltimaVenda;
    
    public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda){
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public Long getQuantidadeVendida() {
        return this.quantidadeVendida;
    }

    public LocalDate getDataUltimaVenda() {
        return this.dataUltimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendas [nomeProduto="  + nomeProduto + ",quantidadeVentidade=" + quantidadeVendida + ",dataUltimaVenda=" + dataUltimaVenda + "]";
    }
}
