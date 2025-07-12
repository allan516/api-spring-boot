package com.vendas.gestao_vendas.repositorio;

import com.vendas.gestao_vendas.entidades.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {

    List<Venda> findByClienteCodigo(Long codigoCliente);
}
