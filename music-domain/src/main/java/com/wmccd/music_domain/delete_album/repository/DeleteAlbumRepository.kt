package com.wmccd.music_domain.delete_album.repository

import com.wmccd.music_domain.delete_album.model.DeleteAlbumDomainModel

interface DeleteAlbumRepository {
    fun deleteAlbum(albumId: String): DeleteAlbumDomainModel
}