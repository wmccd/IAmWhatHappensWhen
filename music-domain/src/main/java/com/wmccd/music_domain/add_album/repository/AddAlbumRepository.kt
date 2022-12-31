package com.wmccd.music_domain.add_album.repository

import com.wmccd.music_domain.add_album.model.AddAlbumDomainModel
import com.wmccd.music_domain.common.model.AlbumDomainModel

interface AddAlbumRepository {
    fun addAlbum(albumDetails: AlbumDomainModel): AddAlbumDomainModel
}