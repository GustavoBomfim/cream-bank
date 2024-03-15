package com.cream.bank.Cream.controller;


import com.cream.bank.Cream.model.entity.Cliente;
import com.cream.bank.Cream.model.repository.ClienteDao;
import com.cream.bank.Cream.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteDao dao;


    @PostMapping(value = "/cadastrar")
    public void cadastrar(@RequestBody Cliente cliente){
        dao.save(cliente);
    }

    @GetMapping(value = "/buscar")
    public List<Cliente> buscar(){
        return dao.findAll();
    }


}
