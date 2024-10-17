package com.book.repository

import com.book.data.Book

class BookRepository {

    // 도서 데이터를 저장하는 리스트
    private val books = mutableListOf<Book>()

    // 새로운 도서를 리스트에 추가
    fun addBook(book: Book) {
        books.add(book)
    }

    // ID로 도서를 찾아 삭제한다. 성공할시 true, 아닐시 false 를 반환
    fun removeBook(id:Int): Boolean {
        return books.removeIf {it.id == id}
    }

    // 모든 도서 리스트를 반환
    fun getAllBooks(): List<Book> {
        return books
    }

    // id로 도서를 찾아 반환 , 없을경우  null 반환
    fun findBookById(id:Int): Book? {
        return books.find { it.id == id }
    }
}