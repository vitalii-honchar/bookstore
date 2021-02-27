package com.weaxme.bookstore.rest.update

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Service
class UpdateBookHandler {

    companion object {
        @JvmStatic
        private val LOG = LoggerFactory.getLogger(UpdateBookHandler::class.java)!!
    }


    fun updateBook(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id")
        return Mono.error<ServerResponse>{ IllegalStateException("BANG!") }
            .doOnSubscribe { LOG.info("Update book: bookId = {}", id) }
    }
}
