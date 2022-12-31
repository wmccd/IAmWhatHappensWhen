package com.wmccd.music_domain.count_albums.repository

import com.wmccd.music_domain.count_albums.model.AlbumCountDomainModel

interface AlbumCountRepository {
    fun albumCount(): AlbumCountDomainModel
}