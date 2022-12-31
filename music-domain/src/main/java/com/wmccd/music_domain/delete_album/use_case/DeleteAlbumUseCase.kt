package com.wmccd.music_domain.delete_album.use_case

import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.clean_architecture.use_case.BackgroundExecutingUseCase
import com.wmccd.music_domain.delete_album.model.DeleteAlbumDomainModel
import com.wmccd.music_domain.delete_album.repository.DeleteAlbumRepository

class DeleteAlbumUseCase(
    private val deleteAlbumRepository: DeleteAlbumRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<String, DeleteAlbumDomainModel>(coroutineContextProvider) {
    override fun executeInBackground(
        request: String
    ) = deleteAlbumRepository.deleteAlbum(request)
}