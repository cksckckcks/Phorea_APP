package com.phorea

data class Image(
    val imageID: Int,
    val url: String,
    var location: String
) {
    fun setLocation(location: String) {
        this.location = location
    }
}
