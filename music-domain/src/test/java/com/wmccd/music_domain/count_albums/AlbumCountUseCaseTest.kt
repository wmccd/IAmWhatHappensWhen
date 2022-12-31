package com.wmccd.music_domain.count_albums

import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.coroutine.FakeCoroutineContextProvider
import com.wmccd.music_domain.count_albums.repository.AlbumCountDummyRepository
import com.wmccd.music_domain.count_albums.use_case.AlbumCountUseCase
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class AlbumCountUseCaseTest {

    private lateinit var albumCountUseCase: AlbumCountUseCase
    private lateinit var coroutineContextProvider: CoroutineContextProvider
    private var dummyRepository = AlbumCountDummyRepository()

    @Before
    fun setUp() {
        coroutineContextProvider = FakeCoroutineContextProvider()

        albumCountUseCase = AlbumCountUseCase(
            dummyRepository,
            coroutineContextProvider
        )
    }

    @Test
    fun `Given all albums when executeInBackground then returns the count of all the  albums`() {
        // Given
        val expectedAlbumCount = AlbumCountDummyRepository().albumCount()

        // When
        val actualResult = albumCountUseCase.executeInBackground("")

        // Then
        assertEquals(expectedAlbumCount, actualResult)

    }
}
