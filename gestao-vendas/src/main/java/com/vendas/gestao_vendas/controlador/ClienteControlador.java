package com.vendas.gestao_vendas.controlador;

import com.vendas.gestao_vendas.dto.cliente.ClienteRequestDTO;
import com.vendas.gestao_vendas.dto.cliente.ClienteResponseDTO;
import com.vendas.gestao_vendas.entidades.Cliente;
import com.vendas.gestao_vendas.servico.ClienteServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    private ClienteServico clienteServico;

    @ApiOperation(value = "Listar", nickname = "listarTodas")
    @GetMapping
    public List<ClienteResponseDTO> listarTodas() {

        return clienteServico.listarTodos().stream()
                .map(cliente -> ClienteResponseDTO.converterParaClienteDTO(cliente)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Listar por código", nickname = "buscarClientePorId")
    @GetMapping("/{codigo}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long codigo) {
        Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigo);
        return cliente.isPresent()
                ? ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(cliente.get()))
                : ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Salvar", nickname = "salvarCliente")
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO clienteDto) {
        Cliente clientesalvo = clienteServico.salvar(clienteDto.converterParaClienteDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteResponseDTO.converterParaClienteDTO(clientesalvo));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long codigo, @Valid @RequestBody ClienteRequestDTO clienteDto) {
        Cliente clienteAtualizado = clienteServico.atualizar(codigo, clienteDto.converterParaClienteDTO(codigo));
        return ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(clienteAtualizado));
    }

}
