package com.sales.sale;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@EnableFeignClients
@EnableResourceServer
@SpringBootApplication
public class SaleApplication {

	@Bean
	public RequestInterceptor getAuthenticationInterceptor(){
		return new RequestInterceptor() {
			@Override
			public void apply (final RequestTemplate requestTemplate) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if(authentication != null){
					OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
					details.getTokenValue();
					requestTemplate.header("Authorization", "Bearer".concat(details.getTokenValue()));
				}
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SaleApplication.class, args);
	}

}
