package ru.ukenov.foodo.domain.main

import ru.ukenov.foodo.domain.models.Images

class GetImagesUseCase(
    private val repository: Repository
) {
    suspend fun invoke(): Images {
        return repository.getImages()
    }
}