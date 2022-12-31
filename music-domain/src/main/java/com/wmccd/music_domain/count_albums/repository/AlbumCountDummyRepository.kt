package com.wmccd.music_domain.count_albums.repository

import com.wmccd.music_domain.count_albums.model.AlbumCountDomainModel

internal class AlbumCountDummyRepository: AlbumCountRepository {
    override fun albumCount() = AlbumCountDomainModel(
        count = 2
    )
}