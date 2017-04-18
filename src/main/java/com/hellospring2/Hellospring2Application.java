package com.hellospring2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hellospring")
@EntityScan("com.hellospring")
public class Hellospring2Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Hellospring2Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Hellospring2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner printAll(ApplicationContext ctx) {
		return args -> {
			System.out.println("All beans :");
			String[] beanNames = ctx.getBeanDefinitionNames();
			for(String bean : beanNames) {
				System.out.println(bean);
			}
		};
	}
	
	
}
