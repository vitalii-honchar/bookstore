package com.weaxme.bookstore.repository

import com.weaxme.bookstore.model.Author
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Int> {

    fun findAll(pageable: Pageable): List<Author>
}
