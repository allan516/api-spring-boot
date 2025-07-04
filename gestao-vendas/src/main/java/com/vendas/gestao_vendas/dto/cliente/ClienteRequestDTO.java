package com.vendas.gestao_vendas.dto.cliente;

import com.vendas.gestao_vendas.entidades.Cliente;
import com.vendas.gestao_vendas.entidades.Endereco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente Requisição DTO")
public class ClienteRequestDTO {

    @ApiModelProperty(value = "Nome")
    private String nome;

    @ApiModelProperty(value = "Telefone")
    private String telefone;

    @ApiModelProperty(value = "Ativo")
    private Boolean ativo;

    @ApiModelProperty(value = "Endereço")
    private EnderecoRequestDTO enderecoRequestDTO;

    public Cliente converterParaClienteDTO() {
        Endereco endereco = new Endereco(enderecoRequestDTO.getLogradouro(), enderecoRequestDTO.getNumero(),
                enderecoRequestDTO.getComplemento(), enderecoRequestDTO.getBairro(), enderecoRequestDTO.getCep(),
                enderecoRequestDTO.getCidade(), enderecoRequestDTO.getEstado());
        return new Cliente(nome, telefone, ativo, endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public EnderecoRequestDTO getEnderecoRequestDTO() {
        return enderecoRequestDTO;
    }

    public void setEnderecoRequestDTO(EnderecoRequestDTO enderecoRequestDTO) {
        this.enderecoRequestDTO = enderecoRequestDTO;
    }
}
