package com.book.service

import com.book.data.Book
import com.book.repository.BookRepository

class BookService(private val repository: BookRepository) {

    // 새로운 도서 추가
    fun addBook(id: Int, title: String, author: String) {
        val book = Book(id, title, author) // 새로운 book 객체 생성
        repository.addBook(book)
    }

    // 도서 ID를 검색하여 도서를 삭제
    fun deleteBook(id: Int) {
        repository.removeBook(id)
    }

    // 모든 도서 목록을 반환한다.
    fun getAllBookList(): List<Book> {
        return repository.getAllBooks()
    }

    // 도서를 대출한다.
    fun borrowBook(id: Int) {
        val book = repository.findBookById(id)
        book?.let {
            if (it.isAvailable) {
                it.isAvailable = false
                // isAvailable true 값이기 때문에 책을 빌릴경우 false 로 바꿔준다.
                println("${book.title} 책이 정상적으로 대여 되었습니다.")
            } else {
                println("${book.title} 책은 이미 대여된 도서 입니다.")
            }
        }
    }

    // 도서를 반환한다.
    fun returnBook(id: Int) {
        val book = repository.findBookById(id)
        if (book != null && !book.isAvailable) {
            book.isAvailable = true
            println("도서가 반납되었습니다: $book")
        } else {
            println("반납할 수 없는 도서입니다.")
        }
    }
}