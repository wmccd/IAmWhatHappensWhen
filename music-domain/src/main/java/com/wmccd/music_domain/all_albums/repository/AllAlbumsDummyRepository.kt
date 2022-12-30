package com.wmccd.music_domain.all_albums.repository

import com.wmccd.music_domain.album_details.model.AlbumDomainModel
import com.wmccd.music_domain.all_albums.model.AllAlbumsDomainModel

class AllAlbumsDummyRepository: AllAlbumsRepository {
    override fun albums() = AllAlbumsDomainModel (
        arrayListOf(
            AlbumDomainModel(
                id = "1",
                title = "Keep on Bobbin'",
                artist = "The Mighty Bobbins",
                discs = 2,
                tracks = 19,
                year = 1999,
                imageUrl = "https://en.wikipedia.org/wiki/Bobbin#/media/File:Hua_Nan_sewing_machine_-_06.jpg"
            ),
            AlbumDomainModel(
                id = "2",
                title = "Head Bobbin'",
                artist = "The Mighty Bobbins",
                discs = 1,
                tracks = 12,
                year = 2002,
                imageUrl = "https://en.wikipedia.org/wiki/Bobbin#/media/File:Hua_Nan_sewing_machine_-_06.jpg"
            )
        )
    )


}
