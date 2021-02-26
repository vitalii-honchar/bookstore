package com.weaxme.bookstore.repository

import com.weaxme.bookstore.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int> {
}
