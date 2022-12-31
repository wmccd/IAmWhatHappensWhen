package com.wmccd.music_domain.album_details.repository

import com.wmccd.music_domain.album_details.model.AlbumDetailsDomainModel
import com.wmccd.music_domain.common.model.AlbumDomainModel

interface AlbumDetailsRepository {
    fun albumDetails(albumId: String): AlbumDetailsDomainModel
}