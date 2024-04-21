package com.cream.bank.Cream.controller;

import com.cream.bank.Cream.model.entity.Cartao;
import com.cream.bank.Cream.model.repository.CartaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "/cartao")
public class CartaoController {

    @Autowired
    private CartaoDao dao;

    @GetMapping(value = "/buscar")
    public Cartao buscarCartao(@RequestParam String numeroConta) {
        return dao.findByNumeroConta(new BigInteger(numeroConta));
    }
}
