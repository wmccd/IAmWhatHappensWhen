package com.wmccd.music_domain.common.model

data class AlbumDomainModel(
    val id: String,
    val title: String,
    val artist: String,
    val discs: Int,
    val tracks: Int,
    val year: Int,
    val imageUrl: String
)
