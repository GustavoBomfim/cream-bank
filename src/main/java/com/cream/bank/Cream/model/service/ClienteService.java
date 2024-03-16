package com.cream.bank.Cream.model.service;

import com.cream.bank.Cream.model.entity.Cliente;
import com.cream.bank.Cream.model.repository.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;
    public void cadastrar(Cliente cliente){
        clienteDao.save(cliente);
    }


    public void desativarCliente(BigInteger numeroConta){
        Cliente cliente = clienteDao.getReferenceById(numeroConta);
        cliente.setAtivo(false);
        clienteDao.save(cliente);
    }
}
