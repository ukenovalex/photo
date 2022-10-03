package ru.ukenov.foodo.domain.main

import ru.ukenov.foodo.domain.models.Images

interface Repository {
    suspend fun getImages(): Images
}