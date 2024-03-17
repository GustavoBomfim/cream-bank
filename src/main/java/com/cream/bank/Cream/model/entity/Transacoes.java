package com.cream.bank.Cream.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "transacoes")
@Table(name = "transacoes")
public class Transacoes {
    @Id @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idTransicao;
    @Column(name = "conta_favorecido")
    private BigInteger contaFavorecido;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "data")
    private Date data;
    @Column(name = "fk_numero_conta")
    private BigInteger numeroContaRemetente; //Remetente é quem faz o pagamento.
}
