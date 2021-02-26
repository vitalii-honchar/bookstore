package com.weaxme.bookstore.rest.read

import com.weaxme.bookstore.config.BookstoreProperties
import com.weaxme.bookstore.model.Author
import com.weaxme.bookstore.repository.AuthorRepository
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
class GetAuthorHandler(
    private val authorRepository: AuthorRepository,
    private val bookstoreProperties: BookstoreProperties
) {
    companion object {
        @JvmStatic
        private val LOG = LoggerFactory.getLogger(GetAuthorHandler::class.java)!!
    }

    fun getAuthors(request: ServerRequest): Mono<ServerResponse> {
        val page = request.queryParamOrNull("page")?.toInt() ?: 0
        return Mono.fromCallable {
            authorRepository.findAll(PageRequest.of(page, bookstoreProperties.limitPerPage, ASC, Author::id.name))
        }.doOnNext { LOG.info("Get authors: page = {}, response = {}", page, it) }
            .flatMap {
                ok()
                    .body(Mono.just(it), Author::class.java)
            }.doOnSubscribe { LOG.info("Get authors: page = {}", page) }
    }

    fun getAuthorById(request: ServerRequest): Mono<ServerResponse> {
        val id = request.pathVariable("id").toInt()
        return Mono.fromCallable { authorRepository.findById(id) }
            .doOnNext { LOG.info("Get author by id: id = {}, response = {}", id, it) }
            .flatMap { ok().body(Mono.just(it), Author::class.java) }
            .doOnSubscribe { LOG.info("Get author by id: id = {}", id) }
    }
}
