package com.vendas.gestao_vendas.repositorio;

import com.vendas.gestao_vendas.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
     Categoria findByNome(String nome);
}
