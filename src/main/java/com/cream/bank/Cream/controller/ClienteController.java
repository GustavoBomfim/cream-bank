package com.cream.bank.Cream.controller;


import com.cream.bank.Cream.model.dto.ClienteLoginDTO;
import com.cream.bank.Cream.model.entity.Cliente;
import com.cream.bank.Cream.model.repository.ClienteDao;
import com.cream.bank.Cream.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.math.BigInteger;
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

    @GetMapping(value = "/buscarPorId")
    public Cliente buscarPorId(@RequestBody BigInteger numeroConta){
        return dao.getReferenceById(numeroConta);
    }
    @GetMapping(value = "/buscarTodos")
    public List<Cliente> buscar(){
        return dao.findAll();
    }
    @PostMapping(value = "/desativar")
    public void desativar(@RequestParam String numeroConta){
        clienteService.desativarCliente(new BigInteger(numeroConta));
    }

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
        }
    }

    @GetMapping(value = "/logar")
    public ResponseEntity logar(@RequestBody ClienteLoginDTO dto){
        Cliente logar = clienteService.logar(new BigInteger(dto.getNumeroConta()), dto.getSenha());
        return ResponseEntity.ok(logar);
    }


}
