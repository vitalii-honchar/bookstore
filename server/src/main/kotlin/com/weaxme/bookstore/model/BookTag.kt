package com.weaxme.bookstore.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "book_tag")
data class BookTag(
    @Id
    @GeneratedValue
    @JsonIgnore
    val id: Int? = null,

    val name: String? = null,

    @Column(name = "book_id")
    val bookId: Int? = null
)
