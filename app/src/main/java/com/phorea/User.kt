package com.phorea

class UserName(val name: String, val nickname: String)

// User 클래스의 생성자
open class User(val userName: UserName) {
    fun getName(): String {
        return userName.name
    }

    fun getNickname(): String {
        return userName.nickname
    }
}
