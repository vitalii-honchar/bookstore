package com.weaxme.bookstore.model

import java.time.Instant
import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_tag", joinColumns = [JoinColumn(name = "book_id")])
    val tags: Set<String>? = null
)
