package com.vendas.gestao_vendas.repositorio;

import com.vendas.gestao_vendas.entidades.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemVendaRepositorio extends JpaRepository<ItemVenda, Long> {

    List<ItemVenda> findByVendaCodigo(Long codigoVenda);
}
