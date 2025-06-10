package com.vendas.gestao_vendas.repositorio;

import com.vendas.gestao_vendas.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
