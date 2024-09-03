package com.github.gabguedes.ms_proposta_credito.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double valorSolicitado;

    @Column(nullable = false)
    private int prazoParaPagamento;

    private boolean aprovado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
