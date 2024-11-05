package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookShelf (
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)