package com.weaxme.bookstore.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.weaxme.bookstore.service.json.BootTagToNameSerializer
import javax.persistence.*

@Entity
@Table(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "author_id")
    val authorId: Int?,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    val author: Author? = null,

    @JsonSerialize(using = BootTagToNameSerializer::class)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    val tags: Set<BookTag>? = null
)
