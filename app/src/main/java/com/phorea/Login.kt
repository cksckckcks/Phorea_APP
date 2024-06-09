package com.phorea

class Login(
    private val username: String,
    private val password: String
) {
    fun check(id: String, password: String): Boolean {
        // 로그인 자격 확인 로직
        return this.username == id && this.password == password
    }
}
