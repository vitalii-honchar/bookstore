package com.weaxme.bookstore.config.router

import com.weaxme.bookstore.rest.read.GetAuthorHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class AuthorRouterConfig {

    @Bean
    fun authorRoutes(getAuthorHandler: GetAuthorHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(GET("/authors"), getAuthorHandler::getAuthors)
            .andRoute(GET("/authors/{id}"), getAuthorHandler::getAuthorById)
    }
}
