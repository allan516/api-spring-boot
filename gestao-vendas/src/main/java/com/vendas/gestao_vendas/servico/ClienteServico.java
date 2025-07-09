package com.vendas.gestao_vendas.servico;

import com.vendas.gestao_vendas.entidades.Categoria;
import com.vendas.gestao_vendas.entidades.Cliente;
import com.vendas.gestao_vendas.excecao.RegraNegocioException;
import com.vendas.gestao_vendas.repositorio.ClienteRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Cliente salvar(Cliente cliente) {
        validarClienteDuplicado(cliente);
        return clienteRepositorio.save(cliente);
    }

    public Cliente atualizar(Long codigo, Cliente cliente) {
        Cliente clienteAtualizar = validarClienteExiste(codigo);
        validarClienteDuplicado(cliente);
        BeanUtils.copyProperties(cliente, clienteAtualizar, "codigo");
        return clienteRepositorio.save(clienteAtualizar);
    }

    private Cliente validarClienteExiste(Long codigo) {
        Optional<Cliente> cliente = buscarPorCodigo(codigo);
        if (cliente.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }

        return cliente.get();
    }

    private void validarClienteDuplicado(Cliente cliente) {
        Cliente clientePorNome = clienteRepositorio.findByNome(cliente.getNome());
        if (clientePorNome != null && clientePorNome.getCodigo() != cliente.getCodigo()) {
            throw new RegraNegocioException(String.format("O cliente %s já está cadastrado", cliente.getNome().toUpperCase()));
        }
    }


}
