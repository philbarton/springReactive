package uk.co.maclon.claimant.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Router {

    @Bean
    public RouterFunction<?> routes(Handler handler) {
        return route(GET("/api/claimants"), handler::findAll)
                .andRoute(GET("/api/claimant/{nino}"), handler::findByNino)
                .andRoute(POST("/api/claimant"), handler::save);
    }
}
