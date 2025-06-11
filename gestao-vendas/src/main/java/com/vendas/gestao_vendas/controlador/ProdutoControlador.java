package com.vendas.gestao_vendas.controlador;

import com.vendas.gestao_vendas.entidades.Produto;
import com.vendas.gestao_vendas.servico.ProdutoServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api(tags = "Produto")
@RestController
@RequestMapping("produto")
public class ProdutoControlador {
    @Autowired
    private ProdutoServico produtoServico;

    @ApiOperation(value = "Listar")
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoServico.listarTodos();
    }

    @ApiOperation(value = "Listar por código")
    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Produto>> listarPorCodigo(@PathVariable Long codigo) {
        Optional<Produto> produto = produtoServico.buscarPorCodigo(codigo);
        return produto.isPresent() ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }
}
