package com.cream.bank.Cream.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "clientes")
@Table(name = "clientes")
public class Cliente {
    @Id @Column(name = "numero_conta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger numeroConta;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "senha")
    private String senha;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "email")
    private String email;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "fk_numero_agencia")
    private Integer agencia;
    @Column(name = "ativo")
    private Boolean ativo;





}
