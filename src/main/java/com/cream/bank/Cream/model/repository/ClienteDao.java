package com.cream.bank.Cream.model.repository;

import com.cream.bank.Cream.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ClienteDao extends JpaRepository<Cliente, BigInteger> {
    Cliente findByNumeroContaAndSenha(BigInteger numeroConta, String senha);
    Cliente findByNumeroConta(BigInteger numeroConta);
}
