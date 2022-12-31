package com.wmccd.music_domain.delete_album.repository

import com.wmccd.music_domain.common.model.EffectedAlbumsDomainModel
import com.wmccd.music_domain.delete_album.model.DeleteAlbumDomainModel

class DeleteAlbumDummyRepository: DeleteAlbumRepository {
    override fun deleteAlbum(albumId: String) = DeleteAlbumDomainModel(
        effectedAlbumsDomainModel = EffectedAlbumsDomainModel(
            effectedCount = 1
        )
    )
}