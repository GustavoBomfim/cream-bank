package com.cream.bank.Cream.model.repository;

import com.cream.bank.Cream.model.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface TransacoesDao extends JpaRepository<Transacoes, BigInteger> {
    List<Transacoes> findAllByNumeroContaRemetente(BigInteger numeroContaRemetente);

    List<Transacoes> findAllByNumeroContaRemetenteOrContaFavorecido(BigInteger contaFavorecido, BigInteger numeroContaRemetente);

}
