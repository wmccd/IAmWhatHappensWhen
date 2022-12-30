package com.wmccd.music_domain.all_albums.repository

import com.wmccd.music_domain.all_albums.model.AllAlbumsDomainModel

interface AllAlbumsRepository {
    fun albums(): AllAlbumsDomainModel
}
