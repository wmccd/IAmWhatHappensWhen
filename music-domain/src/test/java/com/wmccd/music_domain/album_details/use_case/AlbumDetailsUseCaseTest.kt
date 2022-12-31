package com.wmccd.music_domain.album_details.use_case

import com.wmccd.music_domain.album_details.repository.AlbumDetailsDummyRepository
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.coroutine.FakeCoroutineContextProvider
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class AlbumDetailsUseCaseTest {

    private lateinit var albumDetailsUseCase: AlbumDetailsUseCase
    private lateinit var coroutineContextProvider: CoroutineContextProvider
    private var dummyRepository = AlbumDetailsDummyRepository()


    @Before
    fun setUp() {
        coroutineContextProvider = FakeCoroutineContextProvider()

        albumDetailsUseCase = AlbumDetailsUseCase(
            dummyRepository,
            coroutineContextProvider
        )
    }

    @Test
    fun `Given album ID when executeInBackground then returns matching album`() {
        // Given
        val albumId = "albumId"
        val expectedAlbum = AlbumDetailsDummyRepository().albumDetails(albumId)

        // When
        val actualResult = albumDetailsUseCase.executeInBackground(albumId)

        // Then
        assertEquals(expectedAlbum, actualResult)
    }
}
