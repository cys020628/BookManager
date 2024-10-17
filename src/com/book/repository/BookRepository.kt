package com.book.repository

import com.book.data.Book
import java.io.File

class BookRepository {

    // 도서 데이터를 저장하는 리스트
    private val books = mutableListOf<Book>()
    // 데이터를 저장할 파일 경로
    private val filePath = "book.txt"

    init {
        // 프로그램 시작 시 파일에서 데이터 읽어오기
        loadBookData()
    }

    // 새로운 도서를 리스트에 추가
    fun addBook(book: Book) {
        books.add(book)
        saveBookDataFile()
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

    // 도서 데이터를 파일에 저장하는 메서드
    private fun saveBookDataFile() {
        File(filePath).printWriter().use { out ->
            books.forEach { book ->
                out.println("${book.id},${book.title},${book.author},${book.isAvailable}")
            }
        }
    }

    // 파일에서 도서 데이터를 읽어와 리스트에 저장하는 메서드
    private fun loadBookData() {
        val file = File(filePath)
        if(file.exists()) {
            file.forEachLine { line ->
                val parts = line.split(",")
                if(parts.size == 4) {
                    val id = parts[0].toInt()
                    val title = parts[1]
                    val author = parts[2]
                    val isAvailable = parts[3].toBoolean()
                    books.add(Book(id, title, author, isAvailable))
                }
            }
        }
    }
}