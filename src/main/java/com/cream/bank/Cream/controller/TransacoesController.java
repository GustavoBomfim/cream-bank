package com.cream.bank.Cream.controller;

import com.cream.bank.Cream.model.dto.TransacaoDTO;
import com.cream.bank.Cream.model.entity.Transacoes;
import com.cream.bank.Cream.model.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacoesController {

    @Autowired
    TransacoesService transacoesService;

    @PostMapping(value = "/enviarDinheiro")
    public void enviarDinheiro(@RequestBody TransacaoDTO transacaoDTO) throws Exception {
        transacoesService.enviarDinheiro(transacaoDTO);
    }

    @GetMapping(value = "/buscarPorRemetente")
    public List<Transacoes> buscarPorRemetente(@RequestParam String numero){
        return transacoesService.buscarPorRemetente(new BigInteger(numero));
    }

    @GetMapping(value = "/buscarTransferenciasPorCliente")
    public List<Transacoes> buscarTransferenciasPorCliente(@RequestParam String numeroConta){
        return transacoesService.buscarTransferenciasPorCliente(new BigInteger(numeroConta));
    }
}
