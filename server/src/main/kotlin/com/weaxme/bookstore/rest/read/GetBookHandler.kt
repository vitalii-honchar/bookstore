package com.weaxme.bookstore.rest.read

import com.weaxme.bookstore.model.Book
import com.weaxme.bookstore.repository.BookRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.queryParamOrNull
import reactor.core.publisher.Mono

@Service
class GetBookHandler(
    private val bookRepository: BookRepository
) {

    companion object {
        @JvmStatic
        private val LOG = LoggerFactory.getLogger(GetBookHandler::class.java)!!

        private const val LIMIT_PER_PAGE = 20
    }

    fun getBooks(request: ServerRequest): Mono<ServerResponse> {
        val page = request.queryParamOrNull("page")?.toInt() ?: 0
        return Mono.fromCallable {
            bookRepository.findAll(PageRequest.of(page, LIMIT_PER_PAGE))
        }.flatMap {
            ok().body(Mono.just(it), Book::class.java)
        }.doOnSubscribe { LOG.info("Get books: page = {}", page) }
    }

    fun getBookById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id").toInt()
        return Mono.fromCallable { bookRepository.findById(id) }
            .flatMap { ok().body(Mono.just(it), Book::class.java) }
            .doOnSubscribe { LOG.info("Get book by id: id = {}", id) }
    }
}
