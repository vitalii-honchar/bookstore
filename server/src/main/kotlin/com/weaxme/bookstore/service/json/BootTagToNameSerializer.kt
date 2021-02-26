package com.weaxme.bookstore.service.json

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.weaxme.bookstore.model.BookTag

class BootTagToNameSerializer : JsonSerializer<Set<BookTag>>() {

    override fun serialize(
        value: Set<BookTag>,
        gen: JsonGenerator,
        serializers: SerializerProvider
    ) {
        val arr = value.map { it.name }.toTypedArray()
        gen.writeArray(arr, 0, arr.size)
    }
}
