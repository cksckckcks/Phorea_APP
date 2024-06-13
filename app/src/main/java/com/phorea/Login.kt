package com.phorea

class Login(
    private val username: String,
    private val password: String
) {
    fun check(id: String, password: String): Boolean {
        // 로그인 자격 확인 로직 (로그인 액티비티에 구현 해둔 것 옮겨보기)
        return this.username == id && this.password == password
    }
}
