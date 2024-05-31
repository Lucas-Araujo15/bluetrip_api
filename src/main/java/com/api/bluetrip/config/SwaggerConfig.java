package com.api.bluetrip.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI OpenApiConfiguration() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bluetrip")
                        .version("0.0.1")
                        .description("Sistema de gerenciamento de \n" +
                                "cursos para uma universidade. Este sistema deve permite a administração de cursos, \n" +
                                "alunos, e professores, além de gerenciar as inscrições dos alunos nos cursos")
                        .contact(new Contact()
                                .email("lucasaraujo4188@gmail.com")
                                .name("Lucas Araujo")
                                .url("https://github.com/Lucas-Araujo15"))
                        .license(new License()));
    }
}
