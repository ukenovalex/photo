package ru.ukenov.foodo.data

import ru.ukenov.foodo.data.models.ImagesResponse
import ru.ukenov.foodo.domain.models.Images

object MainMap {

    fun mapImagesResponseToImages(images: List<ImagesResponse>) : Images {
        return Images(
            imageList = images.map { it.url }
        )
    }
}