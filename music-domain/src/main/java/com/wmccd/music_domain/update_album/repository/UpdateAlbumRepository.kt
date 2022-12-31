package com.wmccd.music_domain.update_album.repository

import com.wmccd.music_domain.common.model.AlbumDomainModel
import com.wmccd.music_domain.update_album.model.UpdateAlbumDomainModel

interface UpdateAlbumRepository {
    fun updateAlbum(albumDetails: AlbumDomainModel): UpdateAlbumDomainModel
}