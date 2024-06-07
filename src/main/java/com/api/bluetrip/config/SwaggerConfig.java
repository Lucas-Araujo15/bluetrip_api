package com.api.bluetrip.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI OpenApiConfiguration() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bluetrip - API")
                        .version("0.0.1")
                        .description("O Bluetrip é um projeto que visa ser uma plataforma de turismo azul. Ele se destina a conectar comerciantes locais e visitantes, apoiar comunidades costeiras, gerenciar pontos turísticos para evitar superlotações, utilizar inteligência artificial para recomendar rotas personalizadas e promover atividades turísticas sustentáveis ao longo do ano em regiões costeiras.")
                        .license(new License()));
    }
}
