package br.com.gaidzinski07.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.gaidzinski07.message.model"})
@ComponentScan(basePackages = {"br.com.gaidzinski07.message.controller", "br.com.gaidzinski07.message.service"})
public class MessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}

}
