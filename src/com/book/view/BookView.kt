package com.book.view

import com.book.data.Book

class BookView {

    // 메뉴를 표시
    fun showMenu(): Int {
        println("메뉴를 선택하세요.")
        println("1. 도서추가")
        println("2. 도서 삭제")
        println("3. 도서 목록")
        println("4. 도서 대출")
        println("5. 도서 반납")
        println("6. 종료")

        return readlnOrNull()?.toIntOrNull() ?: -1
        // 숫자를 입력받는다. null 값일 경우 -1을 반환한다.
    }

    // 도서의 세부 정보를 입력
    fun getBookInfo(): Triple<Int, String, String> {
        // Triple 함수는 3개의 값을 입력받아 반환할수 있는 함수
        print("도서 ID: ")
        val id = readLine()?.toIntOrNull() ?: -1
        print("도서 제목: ")
        val title = readLine() ?: ""
        print("도서 저자: ")
        val author = readLine() ?: ""
        return Triple(id, title, author)
    }

    // 도서 ID 입력
    fun getBookId(): Int {
        print("도서 ID를 입력하세요 : ")
        return readLine()?.toIntOrNull() ?: -1
    }

    // 도서 목록 출력
    fun getBookList(book:List<Book>) {
        if(book.isEmpty()) {
            println("등록된 도서가 없습니다.")
        }else {
            book.forEach { println("$it") }
        }
    }

    // 프로그램 종료 출력
    fun showExitMessage() {
        println("프로그램을 종료합니다.")
    }

    // 오류 메시지 출력
    fun showErrorMessage(error:String) {
        println("오류 : $error")
    }
}