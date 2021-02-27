package com.weaxme.bookstore.rest.read

import com.weaxme.bookstore.config.BookstoreProperties
import com.weaxme.bookstore.model.Book
import com.weaxme.bookstore.repository.BookRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort.Direction.ASC
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.queryParamOrNull
import reactor.core.publisher.Mono

@Service
class GetBookHandler(
    private val bookRepository: BookRepository,
    private val bookstoreProperties: BookstoreProperties
) {

    companion object {
        @JvmStatic
        private val LOG = LoggerFactory.getLogger(GetBookHandler::class.java)!!
    }

    fun getBooks(request: ServerRequest): Mono<ServerResponse> {
        val page = request.queryParamOrNull("page")?.toInt() ?: 0
        return Mono.fromCallable {
            bookRepository.findAll(PageRequest.of(page, bookstoreProperties.limitPerPage, ASC, Book::id.name))
        }.doOnNext { LOG.info("[HTTP] Get books: page = {}, response = {}", page, it) }
            .flatMap {
                ok().body(Mono.just(it), Book::class.java)
            }.doOnSubscribe { LOG.info("[HTTP] Get books: page = {}", page) }
    }

    fun getBookById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id").toInt()
        return Mono.fromCallable { bookRepository.findById(id) }
            .doOnNext { LOG.info("[HTTP] Get book by id: id = {}, response = {}", id, it) }
            .flatMap { ok().body(Mono.just(it), Book::class.java) }
            .doOnSubscribe { LOG.info("[HTTP] Get book by id: id = {}", id) }
    }
}
