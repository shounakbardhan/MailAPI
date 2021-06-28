package com.hsbc.group.tooling.gqep.MailAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.hsbc.group.tooling.gqep.MailAPI","com.hsbc.group.tooling.gqep.controller"})

@SpringBootApplication
public class MailApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailApiApplication.class, args);
	}

}