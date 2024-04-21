package com.cream.bank.Cream.model.repository;

import com.cream.bank.Cream.model.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;


public interface CartaoDao extends JpaRepository<Cartao, String> {
    Cartao findByNumeroConta(BigInteger numeroConta);

}
