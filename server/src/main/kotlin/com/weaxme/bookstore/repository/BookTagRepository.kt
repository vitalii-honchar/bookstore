package com.weaxme.bookstore.repository

import com.weaxme.bookstore.model.BookTag
import org.springframework.data.repository.CrudRepository

interface BookTagRepository : CrudRepository<BookTag, Int> {
}
