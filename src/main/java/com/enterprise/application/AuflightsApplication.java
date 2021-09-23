package com.enterprise.application;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuflightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuflightsApplication.class, args);
		  
		
		
		//code added to exit from application for dev purpose
		/*System.out.println("Press 'Enter' to terminate");
	    new Scanner(System.in).nextLine();
	    System.out.println("Exiting");
	    System.exit(1);*/
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}



}
