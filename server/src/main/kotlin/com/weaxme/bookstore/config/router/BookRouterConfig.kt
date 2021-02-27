package com.weaxme.bookstore.config.router

import com.weaxme.bookstore.rest.create.CreateBookHandler
import com.weaxme.bookstore.rest.read.GetBookHandler
import com.weaxme.bookstore.rest.update.UpdateBookHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class BookRouterConfig {

    @Bean
    fun bookRoutes(
        createBookHandler: CreateBookHandler,
        getBookHandler: GetBookHandler,
        updateBookHandler: UpdateBookHandler
    ): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(GET("/books"), getBookHandler::getBooks)
            .andRoute(GET("/books/{id}"), getBookHandler::getBookById)
            .andRoute(PUT("/books"), createBookHandler::createBook)
            .andRoute(POST("/books/{id}"), updateBookHandler::updateBook)
    }
}
