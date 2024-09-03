package com.github.gabguedes.ms_proposta_credito.dto;

import com.github.gabguedes.ms_proposta_credito.model.Proposta;
import com.github.gabguedes.ms_proposta_credito.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropostaDTO {

    private Long id;

    @NotNull(message = "Valor Solicitado é obrigatório")
    private double valorSolicitado;

    @NotNull(message = "Prazo para pagamento é obrigatório")
    private int prazoParaPagamento;

    private boolean aprovado;

    private User user;

    public PropostaDTO(Proposta entity) {
        this.id = entity.getId();
        this.valorSolicitado = entity.getValorSolicitado();
        this.prazoParaPagamento = entity.getPrazoParaPagamento();
        this.aprovado = false;
        this.user = entity.getUser();
    }
}
