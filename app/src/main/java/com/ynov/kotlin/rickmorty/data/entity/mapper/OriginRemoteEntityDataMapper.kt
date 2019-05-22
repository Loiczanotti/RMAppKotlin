package com.ynov.kotlin.rickmorty.data.entity.mapper

import com.ynov.kotlin.rickmorty.data.entity.remote.OriginRemoteEntity
import com.ynov.kotlin.rickmorty.data.model.Origin

class OriginRemoteEntityDataMapper {

    fun transformFromRemoteEntity(originRemoteEntity: OriginRemoteEntity): Origin {
        return Origin(
            name = originRemoteEntity.name,
            url = originRemoteEntity.url
        )
    }
}