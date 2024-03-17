package com.cream.bank.Cream.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {
    private BigInteger contaFavorecido;
    private BigInteger contaRemetente;
    private BigDecimal valor;
}
