package com.phorea

class Map(
    var location: String,
    var searchResult: String
) {
    fun searchLocation(query: String): String {
        // 위치 검색 로직
        return searchResult
    }

    fun setLocation(location: String) {
        this.location = location
    }

    fun showPhotoZones(): List<PhotoZone> {
        // 포토존 표시 코드 구현하기
        return listOf()
    }
}
