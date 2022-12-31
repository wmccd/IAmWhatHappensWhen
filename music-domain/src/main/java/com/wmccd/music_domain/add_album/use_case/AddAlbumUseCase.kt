package com.wmccd.music_domain.add_album.use_case

import com.wmccd.music_domain.add_album.model.AddAlbumDomainModel
import com.wmccd.music_domain.add_album.repository.AddAlbumRepository
import com.wmccd.music_domain.common.model.AlbumDomainModel
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.clean_architecture.use_case.BackgroundExecutingUseCase

class AddAlbumUseCase(
    private val addAlbumRepository: AddAlbumRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<AlbumDomainModel, AddAlbumDomainModel>(coroutineContextProvider) {
    override fun executeInBackground(
        request: AlbumDomainModel
    ) = addAlbumRepository.addAlbum(request)
}