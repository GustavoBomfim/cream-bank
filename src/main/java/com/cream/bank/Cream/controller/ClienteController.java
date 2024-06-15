package com.cream.bank.Cream.controller;


import com.cream.bank.Cream.model.dto.ClienteLoginDTO;
import com.cream.bank.Cream.model.entity.Cartao;
import com.cream.bank.Cream.model.entity.Cliente;
import com.cream.bank.Cream.model.repository.CartaoDao;
import com.cream.bank.Cream.model.repository.ClienteDao;
import com.cream.bank.Cream.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteDao dao;
    @Autowired
    private CartaoDao cartaoDao;


    @PostMapping(value = "/cadastrar")
    public void cadastrar(@RequestBody Cliente cliente) {
        cliente = dao.save(cliente);
        Cartao cartao = new Cartao();
        String nome = cliente.getNome() + " " + cliente.getSobrenome();
        cartao.gerarDadosCartao(cliente.getNumeroConta(), nome);
        cartaoDao.save(cartao);
    }

    @GetMapping(value = "/buscarPorId")
    public Cliente buscarPorId(@RequestBody BigInteger numeroConta) {
        return dao.getReferenceById(numeroConta);
    }

    @GetMapping(value = "/buscarTodos")
    public List<Cliente> buscar() {
        return dao.findAll();
    }

    @PostMapping(value = "/desativar")
    public String desativar(@RequestBody ClienteLoginDTO dto) {
        return clienteService.desativarCliente(new BigInteger(dto.getNumeroConta()), dto.getSenha());
    }

    @PostMapping(value = "/logar")
    public ResponseEntity logar(@RequestBody ClienteLoginDTO dto) {
        Cliente logar = clienteService.logar(new BigInteger(dto.getNumeroConta()), dto.getSenha());
        return ResponseEntity.ok(logar);
    }

    @PostMapping(value = "/esqueceuSenha")
    public String esqueceuSenha(@RequestParam String numeroConta){
        return clienteService.gerarSenhaAleatoria(new BigInteger(numeroConta));
    }


}
