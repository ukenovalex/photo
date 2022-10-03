package ru.ukenov.foodo.data.repositories

import ru.ukenov.foodo.data.api.RetrofitInstance
import ru.ukenov.foodo.domain.main.Repository
import ru.ukenov.foodo.domain.models.Images

class MainRepository : Repository {
    override suspend fun getImages(): Images {
        val response = RetrofitInstance.mainAPI.getImages()
        if (response.isSuccessful) {
            response.body()?.let { registerResponse ->
                return Images(registerResponse.map { it.url })
            }
        }
        throw RuntimeException("TODO try catch")
    }
}