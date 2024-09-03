package com.github.gabguedes.ms_proposta_credito.dto;

import com.github.gabguedes.ms_proposta_credito.model.Proposta;
import com.github.gabguedes.ms_proposta_credito.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PropostaResponseDTO {
//    private Long idUser;
//
//    private Long idProposta;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String telefone;

    private double renda;

    private double valorSolicitado;

    private int prazoParaPagamento;

    public PropostaResponseDTO(User user, Proposta proposta) {
        this.nome = user.getNome();
        this.sobrenome = user.getSobrenome();
        this.cpf = user.getCpf();
        this.telefone = user.getTelefone();
        this.renda = user.getRenda();
        this.valorSolicitado = proposta.getValorSolicitado();
        this.prazoParaPagamento = proposta.getPrazoParaPagamento();
    }
}
