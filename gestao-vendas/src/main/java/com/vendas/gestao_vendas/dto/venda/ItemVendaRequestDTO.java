package com.vendas.gestao_vendas.dto.venda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("Itens da venda requisição DTO")
public class ItemVendaRequestDTO {

    @ApiModelProperty(value = "Código produto")
    @NotNull(message = "Código Produto")
    private Long codigoProduto;

    @ApiModelProperty(value = "Quantidade")
    @NotNull(message = "Quantidade")
    @Min(value = 1, message = "Quantidade")
    private Integer quantidade;

    @ApiModelProperty(value = "Preço vendido")
    @NotNull(message = "Preço vendido")
    private BigDecimal precoVendido;

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoVendido() {
        return precoVendido;
    }

    public void setPrecoVendido(BigDecimal precoVendido) {
        this.precoVendido = precoVendido;
    }
}
