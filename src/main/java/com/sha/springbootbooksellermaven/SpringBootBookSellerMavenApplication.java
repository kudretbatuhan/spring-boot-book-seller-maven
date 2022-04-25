package com.sha.springbootbooksellermaven;

import com.sha.springbootbooksellermaven.configuraiton.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class SpringBootBookSellerMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookSellerMavenApplication.class, args);
	}

}
