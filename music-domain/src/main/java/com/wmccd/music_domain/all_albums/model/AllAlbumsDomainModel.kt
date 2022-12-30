package com.wmccd.music_domain.all_albums.model

import com.wmccd.music_domain.album_details.model.AlbumDomainModel

data class AllAlbumsDomainModel(
    val albums: ArrayList<AlbumDomainModel>
)
