package com.wmccd.music_domain.update_album.repository

import com.wmccd.music_domain.common.model.AlbumDomainModel
import com.wmccd.music_domain.common.model.EffectedAlbumsDomainModel
import com.wmccd.music_domain.update_album.model.UpdateAlbumDomainModel

class UpdateAlbumDummyRepository: UpdateAlbumRepository {
    override fun updateAlbum(albumDomainModel: AlbumDomainModel) = UpdateAlbumDomainModel(
        effectedAlbumsDomainModel = EffectedAlbumsDomainModel(
            effectedCount = 1
        )
    )
}