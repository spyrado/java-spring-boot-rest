package br.com.nicolas.config;

import br.com.nicolas.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/*
* a annotation @Configuration diz para o spring boot, que quando ele estiver carregando a aplicação
* ele precisa ler essa classe pq nela vai encontrar configurações sobre o comportamento da aplicação.
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter()); // adicionando o meu converter customizado para yml
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
        // WebMvcConfigurer.super.configureContentNegotiation(configurer);

//        CONFIGURAÇÃO VIA QUERY PARAM
//        // http://localhost:8080/pessoa?mediaType=xml
//        configurer.favorParameter(true) // Aceita parametros
//                .parameterName("mediaType") // nome do parametro aceito
//                .ignoreAcceptHeader(true) // Ignora parametros no header
//                .useRegisteredExtensionsOnly(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML);

        //        CONFIGURAÇÃO VIA HEADER
//        // http://localhost:8080/pessoa
        configurer.favorParameter(false) // não aceita parametros
                .ignoreAcceptHeader(false) // Ignora parametros no header
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
    }
}
