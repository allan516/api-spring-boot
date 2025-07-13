package com.vendas.gestao_vendas.controlador;

import com.vendas.gestao_vendas.dto.venda.ClienteVendaResponseDTO;
import com.vendas.gestao_vendas.servico.VendaServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Venda")
@RestController
@RequestMapping("/venda")
public class VendaControlador {

    @Autowired
    private VendaServico vendaServico;

    @ApiOperation(value = "Listar vendas por cliente", nickname = "listarVendaPorCliente")
    @GetMapping(value = "/cliente/{codigoCliente}")
    public ResponseEntity<ClienteVendaResponseDTO> listarVendaPorCliente(@PathVariable Long codigoCliente) {
        return ResponseEntity.ok(vendaServico.listarVendaPorCliente(codigoCliente));
    }
}
