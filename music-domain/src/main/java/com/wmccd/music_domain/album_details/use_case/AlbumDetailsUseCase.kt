package com.wmccd.music_domain.album_details.use_case

import com.wmccd.music_domain.album_details.model.AlbumDomainModel
import com.wmccd.music_domain.album_details.repository.AlbumDetailsRepository
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.clean_architecture.use_case.BackgroundExecutingUseCase

class AlbumDetailsUseCase(
    private val dishDetailsRepository: AlbumDetailsRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<String, AlbumDomainModel>(coroutineContextProvider) {
    override fun executeInBackground(
        request: String
    ) = dishDetailsRepository.albumDetails(request)

//    override fun executeInBackground(
//        request: String):  AlbumDomainModel {
//         return dishDetailsRepository.albumDetails(request)
//        }
}