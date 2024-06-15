package com.cream.bank.Cream.model.service;

import com.cream.bank.Cream.model.dto.TransacaoDTO;
import com.cream.bank.Cream.model.entity.Cliente;
import com.cream.bank.Cream.model.entity.Transacoes;
import com.cream.bank.Cream.model.repository.ClienteDao;
import com.cream.bank.Cream.model.repository.TransacoesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class TransacoesService {
    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteDao clienteDao;

    @Autowired
    TransacoesDao transacoesDao;

    @Autowired
    EmailService emailService;

    public Cliente enviarDinheiro(TransacaoDTO dto) throws Exception {
        Cliente favorecido = clienteService.buscarCliente(dto.getContaFavorecido());
        Cliente remetente = clienteService.buscarCliente(dto.getContaRemetente());

        if(dto.getContaRemetente().equals(dto.getContaFavorecido())){
            throw new Exception("Não é possível fazer transferência para a sua própria conta.");
        }

        if (!favorecido.getAtivo()) {
            throw new Exception("Favorecido não possui conta ativa.");
        }
        if (!remetente.getAtivo()) {
            throw new Exception("Remetente não possui conta ativa.");
        }

        if (remetente.getSaldo().compareTo(dto.getValor()) >= 0) {
            remetente.setSaldo(remetente.getSaldo().subtract(dto.getValor()));
            favorecido.setSaldo(favorecido.getSaldo().add(dto.getValor()));
        } else {
            throw new Exception("Remetente não possui saldo o suficiente");
        }

        Transacoes transacoes = new Transacoes(null, dto.getContaFavorecido(), dto.getValor(), new Date(), dto.getContaRemetente());
        transacoesDao.save(transacoes);
        clienteDao.save(favorecido);
        clienteDao.save(remetente);
        emailService.enviarEmail("Transferência efetuada com sucesso.", "Sua transferência de R$" + dto.getValor()
                        + " foi efetuada com sucesso",
                "gustavobomfim432@gmail.com");

        emailService.enviarEmail("Transferência recebida.", "Você recebeu uma transferência de R$" + dto.getValor(),
                "gustavobomfim432@gmail.com");
        return remetente;
    }

    public List<Transacoes> buscarPorRemetente(BigInteger numeroConta){
        List<Transacoes> transacoesList = transacoesDao.findAllByNumeroContaRemetente(numeroConta);
        return transacoesList;
    }

    public List<Transacoes> buscarTransferenciasPorCliente(BigInteger numeroContaCliente){
        return transacoesDao.findAllByNumeroContaRemetenteOrContaFavorecido(numeroContaCliente, numeroContaCliente);
    }
}
