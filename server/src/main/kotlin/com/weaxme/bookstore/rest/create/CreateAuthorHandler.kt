package com.weaxme.bookstore.rest.create

import com.weaxme.bookstore.model.Author
import com.weaxme.bookstore.service.author.AuthorService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyExtractors.toMono
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Service
class CreateAuthorHandler(
    private val authorService: AuthorService
) {

    companion object {
        @JvmStatic
        private val LOG = LoggerFactory.getLogger(CreateAuthorHandler::class.java)!!
    }

    fun createAuthor(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(Author::class.java)
            .flatMap { author ->
                authorService.create(author)
                    .flatMap { ok().body(Mono.just(it), Author::class.java) }
                    .doOnSubscribe { LOG.info("[HTTP] Create author: author = {}", author) }
            }
    }
}
