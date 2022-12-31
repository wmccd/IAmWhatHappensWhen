package com.wmccd.music_domain.all_albums.use_case

import com.wmccd.music_domain.all_albums.model.AllAlbumsDomainModel
import com.wmccd.music_domain.all_albums.repository.AllAlbumsRepository
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.clean_architecture.use_case.BackgroundExecutingUseCase

class AllAlbumsUseCase(
    private val allAlbumsRepository: AllAlbumsRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<String, AllAlbumsDomainModel>(coroutineContextProvider) {
    override fun executeInBackground(
        request: String
    ) = allAlbumsRepository.albums()
}