package com.vendas.gestao_vendas.servico;

import com.vendas.gestao_vendas.entidades.Categoria;
import com.vendas.gestao_vendas.entidades.Cliente;
import com.vendas.gestao_vendas.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarTodos() {
        return clienteRepositorio.findAll();
    }

    public Optional<Cliente> buscarPorCodigo(Long codigo) {
        return clienteRepositorio.findById(codigo);
    }
}
