package com.vendas.gestao_vendas.servico;

import com.vendas.gestao_vendas.dto.venda.ClienteVendaResponseDTO;
import com.vendas.gestao_vendas.dto.venda.ItemVendaRequestDTO;
import com.vendas.gestao_vendas.dto.venda.ItemVendaResponseDTO;
import com.vendas.gestao_vendas.dto.venda.VendaResponseDTO;
import com.vendas.gestao_vendas.entidades.ItemVenda;
import com.vendas.gestao_vendas.entidades.Produto;
import com.vendas.gestao_vendas.entidades.Venda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractVendaServico {

    protected ClienteVendaResponseDTO retornandoClienteVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {
        return new ClienteVendaResponseDTO(venda.getCliente().getNome(), Arrays.asList(criandoVendaResponseDTO(
                venda, itensVendaList)));
    }

    protected VendaResponseDTO criandoVendaResponseDTO(Venda venda, List<ItemVenda> itensVendaList) {
        List<ItemVendaResponseDTO> itemVendasResponseDTO = itensVendaList.stream().map(
                this::criandoItensVendaResponseDto
        ).collect(Collectors.toList());

        return new VendaResponseDTO(venda.getCodigo(), venda.getData(), itemVendasResponseDTO);

    }

    protected ItemVendaResponseDTO criandoItensVendaResponseDto(ItemVenda itemVenda) {
        return new ItemVendaResponseDTO(itemVenda.getCodigo(), itemVenda.getQuantidade(), itemVenda.getPrecoVendido(),
                itemVenda.getProduto().getCodigo(), itemVenda.getProduto().getDescricao());
    }

    protected ItemVenda criandoItemVenda(ItemVendaRequestDTO itemVendaDto, Venda venda) {
        return new ItemVenda(itemVendaDto.getQuantidade(),
                itemVendaDto.getPrecoVendido(), new Produto(itemVendaDto.getCodigoProduto()), venda);
    }
}
