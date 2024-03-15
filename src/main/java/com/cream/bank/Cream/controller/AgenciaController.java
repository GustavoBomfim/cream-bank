package com.cream.bank.Cream.controller;

import com.cream.bank.Cream.model.entity.Agencia;
import com.cream.bank.Cream.model.repository.AgenciaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agencia")
public class AgenciaController {

    @Autowired
    AgenciaDao agenciaDao;

    @PostMapping(value = "/cadastrar")
    public void cadastrar(@RequestBody Agencia agencia){
        agenciaDao.save(agencia);
    }
}
