package com.weaxme.bookstore.model

import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    val author: Author? = null,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    val tags: Set<BookTag>? = null
)
