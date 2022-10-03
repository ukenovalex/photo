package ru.ukenov.foodo.data.api

import retrofit2.Response
import retrofit2.http.GET
import ru.ukenov.foodo.data.models.ImagesResponse
import ru.ukenov.foodo.utils.Resource

interface MainAPI {
    @GET("/images")
    suspend fun getImages(): Response<List<ImagesResponse>>
}