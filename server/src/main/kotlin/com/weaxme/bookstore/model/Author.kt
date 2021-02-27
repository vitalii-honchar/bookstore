package com.weaxme.bookstore.model

import javax.persistence.*

@Entity
@Table(name = "author")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null,
)
