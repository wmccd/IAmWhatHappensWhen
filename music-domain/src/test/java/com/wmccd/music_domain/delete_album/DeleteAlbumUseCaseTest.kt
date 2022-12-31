package com.wmccd.music_domain.delete_album

import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.coroutine.FakeCoroutineContextProvider
import com.wmccd.music_domain.delete_album.repository.DeleteAlbumDummyRepository
import com.wmccd.music_domain.delete_album.use_case.DeleteAlbumUseCase
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class DeleteAlbumUseCaseTest {

    private lateinit var deleteAlbumUseCase: DeleteAlbumUseCase
    private lateinit var coroutineContextProvider: CoroutineContextProvider
    private var dummyRepository = DeleteAlbumDummyRepository()

    @Before
    fun setUp() {
        coroutineContextProvider = FakeCoroutineContextProvider()

        deleteAlbumUseCase = DeleteAlbumUseCase(
            dummyRepository,
            coroutineContextProvider
        )
    }

    @Test
    fun `Given all albums when executeInBackground then returns the count albums effected by the delete`() {
        // Given
        val expectedDeleteAlbumCount = DeleteAlbumDummyRepository().deleteAlbum("1")

        // When
        val actualResult = deleteAlbumUseCase.executeInBackground("")

        // Then
        assertEquals(expectedDeleteAlbumCount, actualResult)

    }
}
