package com.weaxme.bookstore.repository

import com.weaxme.bookstore.model.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Int> {
}
