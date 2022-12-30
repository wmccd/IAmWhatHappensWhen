package com.wmccd.music_domain.album_details.repository

import com.wmccd.music_domain.album_details.model.AlbumDomainModel

interface AlbumDetailsRepository {
    fun albumDetails(dishId: String): AlbumDomainModel
}