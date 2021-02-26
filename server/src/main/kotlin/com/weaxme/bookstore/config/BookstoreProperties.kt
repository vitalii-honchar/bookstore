package com.weaxme.bookstore.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "bookstore")
data class BookstoreProperties(
    var limitPerPage: Int = 20
)
