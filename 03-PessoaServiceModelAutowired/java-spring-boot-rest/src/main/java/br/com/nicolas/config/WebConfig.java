package br.com.nicolas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* a annotation @Configuration diz para o spring boot, que quando ele estiver carregando a aplicação
* ele precisa ler essa classe pq nela vai encontrar configurações sobre o comportamento da aplicação.
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
        WebMvcConfigurer.super.configureContentNegotiation(configurer);
    }
}
