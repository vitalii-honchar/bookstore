package com.weaxme.bookstore.service.author


class AuthorNotFoundException(id: Int) : IllegalStateException("Author with id $id not found!")
