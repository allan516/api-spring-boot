package com.vendas.gestao_vendas.dto.produto;

import com.vendas.gestao_vendas.dto.categoria.CategoriaResponseDTO;
import com.vendas.gestao_vendas.entidades.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("Produto retorno DTO")
public class ProdutoResponseDTO {

    @ApiModelProperty(value = "Código")
    private Long codigo;

    @ApiModelProperty(value = "Descrição")
    private String descricao;

    @ApiModelProperty(value = "Quantidade")
    private Integer quantidade;

    @ApiModelProperty(value = "Preço Custo")
    private BigDecimal precoCusto;

    @ApiModelProperty(value = "Preço Venda")
    private BigDecimal precoVenda;

    @ApiModelProperty(value = "Observação")
    private String observacao;

    @ApiModelProperty(value = "Categoria")
    private CategoriaResponseDTO categoria;

    public ProdutoResponseDTO(Long codigo, String descricao, Integer quantidade, BigDecimal precoCusto,
                              BigDecimal precoVenda, String observacao, CategoriaResponseDTO categoria) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.observacao = observacao;
        this.categoria = categoria;
    }

    public static ProdutoResponseDTO converterParaProdutoDTO(Produto produto) {
        return new ProdutoResponseDTO(produto.getCodigo(), produto.getDescricao(), produto.getQuantidade(),
                produto.getPrecoCusto(), produto.getPrecoVenda(),  produto.getObservacao(),
                CategoriaResponseDTO.converterParaCategoriaDTO(produto.getCategoria()));
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public CategoriaResponseDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponseDTO categoria) {
        this.categoria = categoria;
    }
}
