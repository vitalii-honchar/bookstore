package com.weaxme.bookstore.model

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val username: String? = null,
    val password: String? = null
)
