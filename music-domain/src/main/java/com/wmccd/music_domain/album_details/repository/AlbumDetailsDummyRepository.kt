package com.wmccd.music_domain.album_details.repository

import com.wmccd.music_domain.album_details.model.AlbumDomainModel

internal class AlbumDetailsDummyRepository: AlbumDetailsRepository {
    override fun albumDetails(albumId: String) = AlbumDomainModel(
        id = "1",
        title = "Keep on Bobbin'",
        artist = "The Mighty Bobbins",
        discs = 2,
        tracks = 19,
        year = 1999,
        imageUrl = "https://en.wikipedia.org/wiki/Bobbin#/media/File:Hua_Nan_sewing_machine_-_06.jpg"
    )
}