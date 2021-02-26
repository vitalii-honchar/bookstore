package com.weaxme.bookstore

import com.weaxme.bookstore.model.Book
import com.weaxme.bookstore.model.BookTag
import com.weaxme.bookstore.repository.BookRepository
import com.weaxme.bookstore.repository.BookTagRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class DataInitializer(
    private val bookRepository: BookRepository,
    private val bookTagRepository: BookTagRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val book1 = Book(
            name = "Book 1",
            description = "Description 1",
        ).let { bookRepository.save(it) }
        BookTag(name = "Book Tag 1", book = book1)
            .let { bookTagRepository.save(it) }

        val book2 = Book(
            name = "Book 2",
            description = "Description 2",
        ).let { bookRepository.save(it) }
        BookTag(name = "Book Tag 2", book = book2)
            .let { bookTagRepository.save(it) }

        val book3 = Book(
            name = "Book 3",
            description = "Description 3"
        ).let { bookRepository.save(it) }
        BookTag(name = "Book Tag 3", book = book3)
            .let { bookTagRepository.save(it) }
    }
}
