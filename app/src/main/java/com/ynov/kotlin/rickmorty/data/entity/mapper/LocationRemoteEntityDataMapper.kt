package com.ynov.kotlin.rickmorty.data.entity.mapper

import com.ynov.kotlin.rickmorty.data.entity.remote.LocationRemoteEntity
import com.ynov.kotlin.rickmorty.data.model.Location

class LocationRemoteEntityDataMapper {
    fun transformFromRemoteEntity(locationRemoteEntity: LocationRemoteEntity): Location {
        return Location(
            name = locationRemoteEntity.name,
            url = locationRemoteEntity.url
        )
    }
}