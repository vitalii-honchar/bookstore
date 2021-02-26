package com.weaxme.bookstore.config.router

import com.weaxme.bookstore.rest.read.GetBookHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class BookRouterConfig {

    @Bean
    fun bookRoutes(getBookHandler: GetBookHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(GET("/books"), getBookHandler::getBooks)
            .andRoute(GET("/books/{id}"), getBookHandler::getBookById)
    }

}
