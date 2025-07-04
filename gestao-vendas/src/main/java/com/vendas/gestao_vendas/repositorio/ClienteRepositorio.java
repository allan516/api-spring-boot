package com.vendas.gestao_vendas.repositorio;

import com.vendas.gestao_vendas.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findByNome(String nome);
}
