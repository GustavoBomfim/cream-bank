package com.cream.bank.Cream.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

@Entity(name = "cartao")
@Table(name = "cartao")
@Data
public class Cartao {
    @Id
    @Column(name = "numero")
    private String numero;
    @Column(name = "limite")
    private Double limite;
    @Column(name = "cvc")
    private int cvc;
    @Column(name = "validade")
    private LocalDate validade;
    @Column(name = "fk_numero_conta")
    private BigInteger numeroConta;
    @Column(name = "nome")
    private String nome;


    public void gerarDadosCartao(BigInteger numeroConta, String nome) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 20; i++) {
            if (i % 4 == 0 && i != 20) {
                sb.append(" ");
            } else {
                sb.append(random.nextInt(10));
            }
        }
        this.numero = sb.toString();
        this.limite = 1000.00;
        this.cvc = random.nextInt(100, 999);

        LocalDate hoje = LocalDate.now();
        this.validade = hoje.plusYears(5);

        this.numeroConta = numeroConta;
        this.nome = nome;
    }
}
