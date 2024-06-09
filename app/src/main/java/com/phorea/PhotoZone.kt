package com.phorea

import android.os.Build
import androidx.annotation.RequiresApi

class PhotoZone(
    val photoZoneID: Int,
    var location: String,
    var tips: String,
    val photos: MutableList<Image>,
    val author: User,
    var lastModified: Date
) {
    fun addPhoto(photo: Image) {
        photos.add(photo)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun removePhoto(photoID: Int) {
        photos.removeIf { it.imageID == photoID }
    }
}
