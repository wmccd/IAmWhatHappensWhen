package com.wmccd.music_domain.add_album.repository

import com.wmccd.music_domain.add_album.model.AddAlbumDomainModel
import com.wmccd.music_domain.common.model.AlbumDomainModel
import com.wmccd.music_domain.common.model.EffectedAlbumsDomainModel

class AddAlbumDummyRepository: AddAlbumRepository {
    override fun addAlbum(albumDomainModel: AlbumDomainModel) = AddAlbumDomainModel(
        effectedAlbumsDomainModel = EffectedAlbumsDomainModel(
            effectedCount = 1
        )
    )
}