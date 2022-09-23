package ru.ukenov.foodo.data.api

import retrofit2.http.GET
import ru.ukenov.foodo.data.models.ImagesResponse

interface MainAPI {
    @GET("/images")
    suspend fun getImages(): List<ImagesResponse>
}