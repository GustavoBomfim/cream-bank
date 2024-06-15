package com.cream.bank.Cream.model.service;

import com.cream.bank.Cream.model.entity.Cliente;
import com.cream.bank.Cream.model.repository.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private EmailService emailService;

    public void cadastrar(Cliente cliente){
        clienteDao.save(cliente);
    }


    public String desativarCliente(BigInteger numeroConta, String senha){
        Cliente cliente = clienteDao.getReferenceById(numeroConta);

        if (cliente.getSenha().equals(senha) && cliente.getAtivo()) {
            cliente.setAtivo(false);
            clienteDao.save(cliente);
            return "Usuario desativado com sucesso!";
        }
        else if(!cliente.getSenha().equals(senha)) {
            return "Senha incorreta";
        }
        else {
            return "Conta ja esta desativada";
        }

    }


    public Cliente logar(BigInteger numeroConta, String senha){
        Cliente cliente = clienteDao.findByNumeroContaAndSenha(numeroConta, senha);
        if (cliente != null) {
            return cliente;
        }
        cliente = clienteDao.findByNumeroConta(numeroConta);
        if (cliente != null) {
            emailService.enviarEmail("Tentativa de entrar na conta",
                    "Alguém tentou acessar a sua conta com uma senha errada", "gustavobomfim432@gmail.com");
            throw new SecurityException("Senha incorreta");
        }

        throw new NullPointerException("Cliente nao cadastrado.");

    }

    public Cliente buscarCliente(BigInteger numeroConta){
        return clienteDao.findByNumeroConta(numeroConta);
    }
}
