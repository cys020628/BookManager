package com.book.main

import com.book.controller.BookController
import com.book.repository.BookRepository
import com.book.service.BookService
import com.book.view.BookView
import java.lang.ModuleLayer.Controller

fun main() {
    // 각 클래스들을 초기화
    val repository = BookRepository()
    val service = BookService(repository)
    val view = BookView()
    val controller = BookController(service, view)

    // 프로그램 시작
    controller.show()
}