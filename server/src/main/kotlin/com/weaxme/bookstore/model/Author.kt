package com.weaxme.bookstore.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Author(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null,
)
