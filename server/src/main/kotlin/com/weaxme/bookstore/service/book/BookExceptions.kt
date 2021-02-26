package com.weaxme.bookstore.service.book

class BookNotFoundException(id: Int) : IllegalStateException("Book with id $id not found!")
