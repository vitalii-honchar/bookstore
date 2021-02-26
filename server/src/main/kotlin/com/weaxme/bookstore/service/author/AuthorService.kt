package com.weaxme.bookstore.service.author

import com.weaxme.bookstore.model.Author
import com.weaxme.bookstore.repository.AuthorRepository
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {

    companion object {
        @JvmStatic
        private val LOG = LoggerFactory.getLogger(AuthorService::class.java)!!
    }

    fun create(author: Author): Mono<Author> {
        return Mono.fromCallable {
            authorRepository.save(author)
        }.doOnNext { LOG.info("Created author: author = {}", it) }
            .doOnSubscribe { LOG.info("Create author: author = {}", author) }
            .doOnError { LOG.error("Error during create author: author = {}", author, it) }
    }

    fun update(id: Int, updateFunc: (Author) -> Author): Mono<Author> {
        return getById(id)
            .map { updateFunc(it) }
            .flatMap { Mono.fromCallable { authorRepository.save(it) } }
            .doOnNext { LOG.info("Updated author: id = {}, author = {}", id, it) }
            .doOnSubscribe { LOG.info("Update author: id = {}", id) }
            .doOnError { LOG.error("Error during update author: id = {}", id, it) }
    }

    fun getById(id: Int): Mono<Author> {
        return Mono.fromCallable {
            authorRepository.findByIdOrNull(id) ?: throw AuthorNotFoundException(id)
        }.doOnNext { LOG.info("Get author by id: id = {}, author = {}", id, it) }
            .doOnSubscribe { LOG.info("Get author by id: id = {}", id) }
            .doOnError { LOG.error("Error during get author by id: id = {}", id, it) }
    }
}
