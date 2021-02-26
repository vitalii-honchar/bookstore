package com.weaxme.bookstore

import com.weaxme.bookstore.model.Author
import com.weaxme.bookstore.model.Book
import com.weaxme.bookstore.model.BookTag
import com.weaxme.bookstore.model.User
import com.weaxme.bookstore.repository.AuthorRepository
import com.weaxme.bookstore.repository.BookRepository
import com.weaxme.bookstore.repository.BookTagRepository
import com.weaxme.bookstore.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class DataInitializer(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository,
    private val bookTagRepository: BookTagRepository,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val author1 = Author(
            firstName = "Vitalii",
            lastName = "Honchar"
        ).let { authorRepository.save(it) }

        User(
            firstName = "Vitalii",
            lastName = "Honchar",
            email = "weaxme@gmail.com",
            username = "weaxme@gmail.com",
            password = passwordEncoder.encode("qwe")
        ).let { userRepository.save(it) }

        val book1 = Book(
            name = "Book 1",
            description = "Description 1",
            author = author1
        ).let { bookRepository.save(it) }
        BookTag(name = "Book Tag 1", bookId = book1.id)
            .let { bookTagRepository.save(it) }

        val book2 = Book(
            name = "Book 2",
            description = "Description 2",
        ).let { bookRepository.save(it) }
        BookTag(name = "Book Tag 2", bookId = book2.id)
            .let { bookTagRepository.save(it) }

        val book3 = Book(
            name = "Book 3",
            description = "Description 3"
        ).let { bookRepository.save(it) }
        BookTag(name = "Book Tag 3", bookId = book3.id)
            .let { bookTagRepository.save(it) }
    }
}
