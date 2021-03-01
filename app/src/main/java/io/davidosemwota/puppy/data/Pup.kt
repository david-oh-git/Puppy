package io.davidosemwota.puppy.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pup(
    val id: Int,
    val name: String,
    val breed: String,
    val imageUrl: String,
    val gender: String,
    val about: String
    ) : Parcelable
