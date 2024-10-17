package com.book.controller

import com.book.service.BookService
import com.book.view.BookView
import kotlin.system.exitProcess

class BookController(
    private val bookService: BookService,
    private val bookView: BookView
) {
    fun show() {
        while (true) {
            val choice = bookView.showMenu()
            when (choice) {
                // 도서를 추가
                1 -> addBook()
                // 도서를 삭제
                2 -> deleteBook()
                // 전체 도서 목록을 출력
                3 -> showBookList()
                // 도서 대여
                4 -> borrowBook()
                // 도서 반납
                5 -> returnBook()
                // 프로그램 종료
                6 -> exitProgram()
                // 잘못 입력할 시
                else -> println("잘못된 선택입니다.")
            }
        }
    }

    // 도서 추가 처리
    private fun addBook() {
        val (id, title, author) = bookView.getBookInfo()
        // getBookInfo() 함수의 Triple 을 통해 위 변수에 한번에 담는다.
        bookService.addBook(id, title, author)
    }

    // 도서 삭제 처리
    private fun deleteBook() {
        val id = bookView.getBookId() // 삭제할 도서 ID 입력
        bookService.deleteBook(id)
    }

    // 도서 목록 보기 처리
    private fun showBookList() {
        val books = bookService.getAllBookList()
        bookView.getBookList(books)
    }

    // 도서 대출 처리
    private fun borrowBook() {
        val id = bookView.getBookId()  // 대출할 도서 ID 입력 받기
        bookService.borrowBook(id)  // BookService를 통해 도서 대출
    }

    // 도서 반납 처리
    private fun returnBook() {
        val id = bookView.getBookId()  // 반납할 도서 ID 입력 받기
        bookService.returnBook(id)  // BookService를 통해 도서 반납
    }

    // 프로그램 종료
    private fun exitProgram() {
        bookView.showExitMessage() // 프로그램 종료 메시지 출력
        exitProcess(0) // 프로그램을 종료한다.
    }
}