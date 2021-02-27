package com.weaxme.bookstore.rest.create

import com.weaxme.bookstore.model.Book
import com.weaxme.bookstore.service.book.BookService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Service
class CreateBookHandler(
    private val bookService: BookService
) {

    companion object {
        @JvmStatic
        private val LOG = LoggerFactory.getLogger(CreateBookHandler::class.java)!!
    }

    fun createBook(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(Book::class.java)
            .flatMap { book ->
                bookService.create(book)
                    .flatMap { ok().body(Mono.just(it), Book::class.java) }
                    .doOnSubscribe { LOG.info("[HTTP] Create book: book = {}", book) }
            }
    }
}
