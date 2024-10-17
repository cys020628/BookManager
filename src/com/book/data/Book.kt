package com.book.data

data class Book(
    val id: Int, // 도서 ID
    var title: String, // 도서 제목
    var author: String, // 도서 저자
    var isAvailable: Boolean = true // 도서 대출 가능 여부 (기본값) true
)