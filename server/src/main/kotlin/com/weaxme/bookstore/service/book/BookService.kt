package com.weaxme.bookstore.service.book

import com.weaxme.bookstore.model.Book
import com.weaxme.bookstore.repository.BookRepository
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    companion object {
        @JvmStatic
        private val LOG = LoggerFactory.getLogger(BookService::class.java)!!
    }

    fun create(book: Book): Mono<Book> {
        return Mono.fromCallable {
            bookRepository.save(book)
        }.doOnSubscribe { LOG.info("Create book: book = {}", book) }
            .doOnNext { LOG.info("Created book: book = {}", book) }
            .doOnError { LOG.error("Error during create book: book = {}", book, it) }
    }

    fun update(id: Int, updateFunc: (Book) -> Book): Mono<Book> {
        return getById(id)
            .map { updateFunc(it) }
            .flatMap { Mono.fromCallable { bookRepository.save(it) } }
            .doOnSubscribe { LOG.info("Update book: id = {}", id) }
            .doOnNext { LOG.info("Updated book: id = {}, book = {}", id, it) }
            .doOnError { LOG.error("Error during update book: id = {}", id, it) }
    }

    fun getById(id: Int): Mono<Book> {
        return Mono.fromCallable {
            bookRepository.findByIdOrNull(id) ?: throw BookNotFoundException(id)
        }.doOnSubscribe { LOG.info("Get book by id: id = {}", id) }
            .doOnNext { LOG.info("Get book by id: id = {}, book = {}", id, it) }
            .doOnError { LOG.error("Error during get book by id: id = {}", id, it) }
    }
}
