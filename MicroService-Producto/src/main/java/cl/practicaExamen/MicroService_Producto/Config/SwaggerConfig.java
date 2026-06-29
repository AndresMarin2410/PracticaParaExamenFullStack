package cl.practicaExamen.MicroService_Producto.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("OPEN API 2026 Producto")
                        .version("1.0")
                        .description("Documentacion de la API para productos"));
    }
}
