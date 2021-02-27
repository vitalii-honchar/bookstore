package com.weaxme.bookstore.service.book

import com.weaxme.bookstore.model.Book

class BookNotFoundException(id: Int) : IllegalStateException("Book with id $id not found!")

class BookCreateException(book: Book) : IllegalStateException("Error during create book $book!")
