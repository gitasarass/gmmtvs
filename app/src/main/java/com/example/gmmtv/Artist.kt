package com.example.gmmtv

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    val name: String,
    val born: String,
    val description: String,
    val photo: Int,
    val photo2: Int,
    val photo3: Int,
    val drama: String,
    val photo4: Int,
    val drama2: String,
    val photo5: Int,
    val drama3: String
) : Parcelable