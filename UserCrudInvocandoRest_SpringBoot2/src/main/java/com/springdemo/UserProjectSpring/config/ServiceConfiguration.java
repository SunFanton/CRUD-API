package com.springdemo.UserProjectSpring.config;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

	@Value("${service.persona.url}")
	String url;
	
	@Bean
	Client getClient() {
		Client client = ClientBuilder.newClient();	
		return client;
	}
	
	@Bean
	WebTarget getWebTarget(){
		return getClient().target(url);
	}
	
	
	
}
