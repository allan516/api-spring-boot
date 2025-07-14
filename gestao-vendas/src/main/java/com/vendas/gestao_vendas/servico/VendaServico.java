package com.vendas.gestao_vendas.servico;

import com.vendas.gestao_vendas.dto.venda.ClienteVendaResponseDTO;
import com.vendas.gestao_vendas.dto.venda.VendaResponseDTO;
import com.vendas.gestao_vendas.entidades.Cliente;
import com.vendas.gestao_vendas.entidades.ItemVenda;
import com.vendas.gestao_vendas.entidades.Venda;
import com.vendas.gestao_vendas.excecao.RegraNegocioException;
import com.vendas.gestao_vendas.repositorio.ItemVendaRepositorio;
import com.vendas.gestao_vendas.repositorio.VendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaServico extends AbstractVendaServico {


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
                .map(venda -> criandoVendaResponseDTO(
                        venda, itemVendaRepositorio.findByVendaCodigo(venda.getCodigo()))).collect(Collectors.toList());
        return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDtoList);
    }

    public ClienteVendaResponseDTO listarVendaPorCodigo(Long codigoVenda) {
        Venda venda = validarVendaExiste(codigoVenda);
        List<ItemVenda> itensVendaList = itemVendaRepositorio.findByVendaCodigo(venda.getCodigo());

        return new ClienteVendaResponseDTO(venda.getCliente().getNome(), Arrays.asList(criandoVendaResponseDTO(venda, itensVendaList)));
    }

    private Venda validarVendaExiste(Long codigoVenda) {
        Optional<Venda> venda = vendaRepositorio.findById(codigoVenda);
        if (venda.isEmpty()) {
            throw new RegraNegocioException(String.format("Venda de código %s não enconstrada.", codigoVenda));
        }
        return venda.get();
    }

    private Cliente validarClienteVendaExiste(Long cogigoCliente) {
        Optional<Cliente> cliente = clienteServico.buscarPorCodigo(cogigoCliente);

        if (cliente.isEmpty()) {
            throw new RegraNegocioException(String.format(
                    "O cliente de codigo %s informado não existe no cadastro", cogigoCliente));
        }

        return cliente.get();
    }

}
