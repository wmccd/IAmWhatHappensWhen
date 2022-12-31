package com.wmccd.music_domain.update_album

import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.common.model.AlbumDomainModel
import com.wmccd.music_domain.coroutine.FakeCoroutineContextProvider
import com.wmccd.music_domain.update_album.repository.UpdateAlbumDummyRepository
import com.wmccd.music_domain.update_album.use_case.UpdateAlbumUseCase
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class UpdateAlbumUseCaseTest {

    private lateinit var updateAlbumUseCase: UpdateAlbumUseCase
    private lateinit var coroutineContextProvider: CoroutineContextProvider
    private var dummyRepository = UpdateAlbumDummyRepository()

    @Before
    fun setUp() {
        coroutineContextProvider = FakeCoroutineContextProvider()

        updateAlbumUseCase = UpdateAlbumUseCase(
            dummyRepository,
            coroutineContextProvider
        )
    }

    @Test
    fun `Given all albums when executeInBackground then returns the count of all the albums impacted by the update`() {

        // Given
        val albumDomainModel = AlbumDomainModel(
            id = "1",
            title =  "title",
            artist = "artist",
            discs = 1,
            tracks = 12,
            year = 1995,
            imageUrl = "url"
        )
        val expectedUpdateAlbumCount = UpdateAlbumDummyRepository().updateAlbum(
            albumDomainModel = albumDomainModel
        )

        // When
        val actualResult = updateAlbumUseCase.executeInBackground(request = albumDomainModel)

        // Then
        assertEquals(expectedUpdateAlbumCount, actualResult)
    }
}
