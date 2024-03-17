package com.cream.bank.Cream.controller;

import com.cream.bank.Cream.model.dto.TransacaoDTO;
import com.cream.bank.Cream.model.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacoesController {

    @Autowired
    TransacoesService transacoesService;

    @PostMapping(value = "/enviarDinheiro")
    public void enviarDinheiro(@RequestBody TransacaoDTO transacaoDTO) throws Exception {
        transacoesService.enviarDinheiro(transacaoDTO);
    }
}
