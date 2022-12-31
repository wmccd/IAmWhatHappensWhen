package com.wmccd.music_domain.all_albums.use_case

import com.wmccd.music_domain.all_albums.repository.AllAlbumsDummyRepository
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.coroutine.FakeCoroutineContextProvider
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class AllAlbumsUseCaseTest {

    private lateinit var allAlbumsUseCase: AllAlbumsUseCase
    private lateinit var coroutineContextProvider: CoroutineContextProvider
    private var dummyRepository = AllAlbumsDummyRepository()

    @Before
    fun setUp() {
        coroutineContextProvider = FakeCoroutineContextProvider()

        allAlbumsUseCase = AllAlbumsUseCase(
            dummyRepository,
            coroutineContextProvider
        )
    }

    @Test
    fun `Given all albums when executeInBackground then returns all albums`() {
        // Given
        val expectedAlbums = AllAlbumsDummyRepository().albums()
        val expectedSize = expectedAlbums.albums.size

        // When
        val actualResult = allAlbumsUseCase.executeInBackground("")

        // Then
        assertEquals(expectedAlbums, actualResult)
        assertEquals(expectedAlbums.albums.size, expectedSize)

    }
}
