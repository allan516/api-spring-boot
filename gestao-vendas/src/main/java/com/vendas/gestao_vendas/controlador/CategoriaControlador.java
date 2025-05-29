package com.vendas.gestao_vendas.controlador;

import com.vendas.gestao_vendas.entidades.Categoria;
import com.vendas.gestao_vendas.servico.CategoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {

    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping
    public List<Categoria> listarTodas() {
        return categoriaServico.listarTodas();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable Long codigo) {
        Optional<Categoria> categoria = categoriaServico.buscarPorCodigo(codigo);
        return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria) {
        Categoria categoriasalva = categoriaServico.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriasalva);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Categoria> atualizar(@Valid @PathVariable Long codigo, @RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaServico.atualizar(codigo, categoria));
    }
/*
Observação:
 Quando o obj é recebido pelo post ele não vem na url da requisição e sim pelo corpo da requisição http,dessa forma,
 não sendo preciso usar o @PathVariable e sim o @RequestBody
 */

}
