package com.cream.bank.Cream;

import com.cream.bank.Cream.model.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreamBankApplication {

	public static void main(String[] args) {
//		EmailService service = new EmailService();
//		service.enviarEmail();
		SpringApplication.run(CreamBankApplication.class, args);
	}

}
