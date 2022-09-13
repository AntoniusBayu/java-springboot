package SpringCloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class cloudConfig {
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/car/**")
                        .uri("http://localhost:8082/"))
                .route(r -> r.path("/api/v1/customer/**")
                        .uri("http://localhost:8081/"))
                .route(r -> r.path("/api/v1/customerkafka/**")
                        .uri("http://localhost:8083/"))
                .build();
    }
}
