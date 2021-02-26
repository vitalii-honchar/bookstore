package com.weaxme.bookstore.repository

import com.weaxme.bookstore.model.Book
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface BookRepository : CrudRepository<Book, Int> {
    fun findAll(pageable: Pageable): List<Book>
}
