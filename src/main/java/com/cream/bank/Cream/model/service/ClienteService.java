package com.cream.bank.Cream.model.service;

import com.cream.bank.Cream.model.entity.Cliente;
import com.cream.bank.Cream.model.repository.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.Random;

@Service
public class ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private EmailService emailService;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public void cadastrar(Cliente cliente) {
        clienteDao.save(cliente);
    }


    public String desativarCliente(BigInteger numeroConta, String senha) {
        Cliente cliente = clienteDao.getReferenceById(numeroConta);

        if (cliente.getSenha().equals(senha) && cliente.getAtivo()) {
            cliente.setAtivo(false);
            clienteDao.save(cliente);
            return "Usuario desativado com sucesso!";
        } else if (!cliente.getSenha().equals(senha)) {
            return "Senha incorreta";
        } else {
            return "Conta ja esta desativada";
        }

    }


    public Cliente logar(BigInteger numeroConta, String senha) {
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

    public Cliente buscarCliente(BigInteger numeroConta) {
        return clienteDao.findByNumeroConta(numeroConta);
    }

    public String gerarSenhaAleatoria(BigInteger numeroConta) {
        Cliente cliente = clienteDao.findByNumeroConta(numeroConta);

        if (cliente != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 8; i++) {
                int index = random.nextInt(CHARACTERS.length());
                stringBuilder.append(CHARACTERS.charAt(index));
            }
            String senha = stringBuilder.toString();

            cliente.setSenha(stringBuilder.toString());
            clienteDao.save(cliente);

            String mensagem = "Sua nova senha foi gerada: " + senha + " \n Recomendamos trocar após fazer o login.";

            emailService.enviarEmail("Nova Senha",
                    mensagem, "gustavobomfim432@gmail.com");

            return senha;
        }
        throw new NullPointerException("Cliente nao cadastrado.");

    }
}
