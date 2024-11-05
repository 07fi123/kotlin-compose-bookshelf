package com.example.bookshelf.network


import com.example.bookshelf.model.BookShelf
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET


private const val BASE_URL = "https://www.googleapis.com/books/v1/volumes?q=jazz+history"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<BookShelf>
}

object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}