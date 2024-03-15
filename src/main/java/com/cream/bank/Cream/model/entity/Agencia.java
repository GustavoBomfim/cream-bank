package com.cream.bank.Cream.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "agencia")
@Table(name = "agencia")
public class Agencia {
    @Id
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "endereco")
    private String endereco;
}