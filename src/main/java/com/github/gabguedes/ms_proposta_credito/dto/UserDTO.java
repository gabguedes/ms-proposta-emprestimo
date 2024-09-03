package com.github.gabguedes.ms_proposta_credito.dto;

import com.github.gabguedes.ms_proposta_credito.model.Proposta;
import com.github.gabguedes.ms_proposta_credito.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {


    private Long id;

    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Sobrenome é obrigatório")
    private String sobrenome;

    @NotNull(message = "CPF é obrigatório")
    private String cpf;

    @NotNull(message = "Telefone é obrigatório")
    private String telefone;

    @NotNull(message = "Renda é obrigatória")
    private double renda;

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.cpf = entity.getCpf();
        this.telefone = entity.getTelefone();
        this.renda = entity.getRenda();
    }
}
