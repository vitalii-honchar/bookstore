package com.weaxme.bookstore.model

import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    val tags: Set<BookTag>? = null
)
