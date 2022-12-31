package com.wmccd.music_domain.album_details.use_case

import com.wmccd.music_domain.album_details.model.AlbumDetailsDomainModel
import com.wmccd.music_domain.album_details.repository.AlbumDetailsRepository
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.clean_architecture.use_case.BackgroundExecutingUseCase

class AlbumDetailsUseCase(
    private val albumDetailsRepository: AlbumDetailsRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<String, AlbumDetailsDomainModel>(coroutineContextProvider) {
    override fun executeInBackground(
        request: String
    ) = albumDetailsRepository.albumDetails(request)
}