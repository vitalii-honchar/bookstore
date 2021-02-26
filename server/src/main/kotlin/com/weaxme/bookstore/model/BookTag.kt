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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonIgnore
    val book: Book? = null
)
