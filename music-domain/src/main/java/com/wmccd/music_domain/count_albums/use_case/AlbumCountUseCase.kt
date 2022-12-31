package com.wmccd.music_domain.count_albums.use_case

import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.clean_architecture.use_case.BackgroundExecutingUseCase
import com.wmccd.music_domain.count_albums.model.AlbumCountDomainModel
import com.wmccd.music_domain.count_albums.repository.AlbumCountRepository

class AlbumCountUseCase(
    private val albumCountRepository: AlbumCountRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<String, AlbumCountDomainModel>(coroutineContextProvider) {
    override fun executeInBackground(
        request: String
    ) = albumCountRepository.albumCount()

}