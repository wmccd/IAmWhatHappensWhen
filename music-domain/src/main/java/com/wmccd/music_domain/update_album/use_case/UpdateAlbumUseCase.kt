package com.wmccd.music_domain.update_album.use_case

import com.wmccd.music_domain.common.model.AlbumDomainModel
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.clean_architecture.use_case.BackgroundExecutingUseCase
import com.wmccd.music_domain.update_album.model.UpdateAlbumDomainModel
import com.wmccd.music_domain.update_album.repository.UpdateAlbumRepository

class UpdateAlbumUseCase(
    private val updateAlbumRepository: UpdateAlbumRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<AlbumDomainModel, UpdateAlbumDomainModel>(coroutineContextProvider) {
    override fun executeInBackground(
        request: AlbumDomainModel
    ) = updateAlbumRepository.updateAlbum(request)
}