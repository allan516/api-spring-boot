package com.vendas.gestao_vendas.repositorio;

import com.vendas.gestao_vendas.entidades.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemVendaRepositorio extends JpaRepository<ItemVenda, Long> {

    @Query("select new com.vendas.gestao_vendas.entidades.ItemVenda("
    + " iv.codigo, iv.quantidade, iv.precoVendido, iv.produto, iv.venda)"
    + " from ItemVenda iv"
    + " where iv.venda.codigo = :codigoVenda")
    List<ItemVenda> findByVendaPorCodigo(Long codigoVenda);
}

