package com.wmccd.music_domain.add_album

import com.wmccd.music_domain.add_album.repository.AddAlbumDummyRepository
import com.wmccd.music_domain.add_album.use_case.AddAlbumUseCase
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.common.model.AlbumDomainModel
import com.wmccd.music_domain.coroutine.FakeCoroutineContextProvider
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class AddAlbumUseCaseTest {

    private lateinit var addAlbumUseCase: AddAlbumUseCase
    private lateinit var coroutineContextProvider: CoroutineContextProvider
    private var dummyRepository = AddAlbumDummyRepository()

    @Before
    fun setUp() {
        coroutineContextProvider = FakeCoroutineContextProvider()

        addAlbumUseCase = AddAlbumUseCase(
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
        val expectedAddAlbumCount = AddAlbumDummyRepository().addAlbum(
            albumDomainModel = albumDomainModel
        )

        // When
        val actualResult = addAlbumUseCase.executeInBackground(request = albumDomainModel)

        // Then
        assertEquals(expectedAddAlbumCount, actualResult)
    }
}
