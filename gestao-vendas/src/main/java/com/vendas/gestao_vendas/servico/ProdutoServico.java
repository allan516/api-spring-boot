package com.vendas.gestao_vendas.servico;

import com.vendas.gestao_vendas.entidades.Produto;
import com.vendas.gestao_vendas.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public List<Produto> listarTodos(Long codigoCategoria) {
        return produtoRepositorio.findByCategoriaCodigo(codigoCategoria);
    }

    public Optional<Produto> buscarPorCodigo(Long codigo, Long codigoCategoria) {
        return produtoRepositorio.buscarPorCodigo(codigo, codigoCategoria);
    }

    public Produto salvar(Produto produto) {
        return produtoRepositorio.save(produto);
    }
}
