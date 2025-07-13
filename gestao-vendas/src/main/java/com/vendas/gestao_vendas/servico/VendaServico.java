package com.vendas.gestao_vendas.servico;

import com.vendas.gestao_vendas.dto.venda.ClienteVendaResponseDTO;
import com.vendas.gestao_vendas.dto.venda.ItemVendaResponseDTO;
import com.vendas.gestao_vendas.dto.venda.VendaResponseDTO;
import com.vendas.gestao_vendas.entidades.Cliente;
import com.vendas.gestao_vendas.entidades.ItemVenda;
import com.vendas.gestao_vendas.entidades.Venda;
import com.vendas.gestao_vendas.excecao.RegraNegocioException;
import com.vendas.gestao_vendas.repositorio.ItemVendaRepositorio;
import com.vendas.gestao_vendas.repositorio.VendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaServico {


    private VendaRepositorio vendaRepositorio;
private ItemVendaRepositorio itemVendaRepositorio;
    private ClienteServico clienteServico;

    @Autowired
    public VendaServico(VendaRepositorio vendaRepositorio, ClienteServico clienteServico, ItemVendaRepositorio itemVendaRepositorio) {
        this.vendaRepositorio = vendaRepositorio;
        this.clienteServico = clienteServico;
        this.itemVendaRepositorio = itemVendaRepositorio;
    }

    public ClienteVendaResponseDTO listarVendaPorCliente(Long cogigoCliente) {
        Cliente cliente = validarClienteVendaExiste(cogigoCliente);
        List<VendaResponseDTO> vendaResponseDtoList = vendaRepositorio.findByClienteCodigo(cogigoCliente).stream()
                .map(this::criandoVendaResponseDTO).collect(Collectors.toList());
        return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDtoList);
    }

    private Cliente validarClienteVendaExiste(Long cogigoCliente) {
        Optional<Cliente> cliente = clienteServico.buscarPorCodigo(cogigoCliente);

        if (cliente.isEmpty()) {
            throw new RegraNegocioException(String.format(
                    "O cliente de codigo %s informado não existe no cadastro", cogigoCliente));
        }

        return cliente.get();
    }

    private VendaResponseDTO criandoVendaResponseDTO(Venda venda) {
        List<ItemVendaResponseDTO> itemVendasResponseDTO = itemVendaRepositorio.findByVendaCodigo(venda.getCodigo()).stream().map(
                this::criandoItensVendaResponseDto
        ).collect(Collectors.toList());

        return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itemVendasResponseDTO);

    }

    private ItemVendaResponseDTO criandoItensVendaResponseDto(ItemVenda itemVenda) {
        return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(),
                itemVenda.getProduto().getCodigo(), itemVenda.getProduto().getDescricao());
    }
}
