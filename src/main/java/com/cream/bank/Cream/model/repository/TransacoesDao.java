package com.cream.bank.Cream.model.repository;

import com.cream.bank.Cream.model.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TransacoesDao extends JpaRepository<Transacoes, BigInteger> {
}
