package com.wmccd.music_domain.clean_architecture.use_case

import com.wmccd.music_domain.album_details.model.AlbumDetailsDomainModel
import com.wmccd.music_domain.common.model.AlbumDomainModel
import com.wmccd.music_domain.album_details.repository.AlbumDetailsDummyRepository
import com.wmccd.music_domain.album_details.repository.AlbumDetailsRepository
import com.wmccd.music_domain.album_details.use_case.AlbumDetailsUseCase
import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import com.wmccd.music_domain.clean_architecture.exception.DomainException
import com.wmccd.music_domain.clean_architecture.exception.UnknownDomainException
import com.wmccd.music_domain.coroutine.FakeCoroutineContextProvider
import junit.framework.Assert.*
import kotlinx.coroutines.CoroutineScope
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CancellationException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class UseCaseExecutorTest {

    companion object{
        internal const val THROWN_EXCEPTION_MESSAGE : String = "THROWN_EXCEPTION_MESSAGE"
        internal const val THROWN_CANCELLATION_EXCEPTION_MESSAGE : String = "THROWN_CANCELLATION_EXCEPTION_MESSAGE"
        internal const val UNKNOWN_DOMAIN_EXCEPTION_MESSAGE : String = "UNKNOWN_DOMAIN_EXCEPTION_MESSAGE"
    }

    private lateinit var coroutineContextProvider: CoroutineContextProvider
    private lateinit var scope: CoroutineScope


    @Before
    fun setUp() {
        coroutineContextProvider = FakeCoroutineContextProvider()
        scope = CoroutineScope(coroutineContextProvider.main)

    }

    @Test
    fun `Given dish ID when execute then returns matching album`() {
        // Given
        val albumDetailsRepository = AlbumDetailsDummyRepository()
        val albumDetailsUseCase = AlbumDetailsUseCase(
            albumDetailsRepository,
            coroutineContextProvider
        )
        val albumId = "albumId"
        val expectedAlbumDomainModel = AlbumDetailsDummyRepository().albumDetails(albumId)
        val useCaseExecutor = UseCaseExecutor( scope )
        val countDownLatch = CountDownLatch(1)
        val expectedCountDown = 0L

        fun onResult(albumDetailsDomainModel: AlbumDetailsDomainModel){
            assertEquals(expectedAlbumDomainModel, albumDetailsDomainModel)
            countDownLatch.countDown()
        }

        fun onException( domainException: DomainException){
            fail("Unexpectedly in onException")
        }

        // When
        useCaseExecutor.execute(
            useCase = albumDetailsUseCase,
            value = albumId,
            onResult = ::onResult,
            onException = ::onException
        )

        countDownLatch.await(100, TimeUnit.MILLISECONDS)

        // Then
        assertEquals(expectedCountDown, countDownLatch.count)
    }

    @Test
    fun `Given album ID when execute encounters exception then exception callback is fired`() {
        // Given
        val albumDetailsRepository = AlbumDetailsRepositoryThrowsException()
        val albumDetailsUseCase = AlbumDetailsUseCase(
            albumDetailsRepository,
            coroutineContextProvider
        )
        val albumId = "albumId"
        val useCaseExecutor = UseCaseExecutor( scope )
        val countDownLatch = CountDownLatch(1)
        val expectedCountDown = 0L

        fun onResult(albumDetailsDomainModel: AlbumDetailsDomainModel){
            fail("Unexpectedly in onResult")
        }

        fun onException( domainException: DomainException){
            val actualMessage: String = domainException.message.toString()
            assertTrue("contains message", actualMessage.contains(THROWN_EXCEPTION_MESSAGE))
            countDownLatch.countDown()
        }

        // When
        useCaseExecutor.execute(
            useCase = albumDetailsUseCase,
            value = albumId,
            onResult = ::onResult,
            onException = ::onException
        )

        countDownLatch.await(100, TimeUnit.MILLISECONDS)

        // Then
        assertEquals(expectedCountDown, countDownLatch.count)
    }

    @Test
    fun `Given album ID when execute encounters cancellation exception then no callbacks are fired`() {
        // Given
        val albumDetailsRepository = AlbumDetailsRepositoryThrowsCancellationException()
        val albumDetailsUseCase = AlbumDetailsUseCase(
            albumDetailsRepository,
            coroutineContextProvider
        )

        val albumId = "albumId"
        val useCaseExecutor = UseCaseExecutor( scope )
        val countDownLatch = CountDownLatch(1)
        val expectedCountDown = 1L

        fun onResult(albumDetailsDomainModel: AlbumDetailsDomainModel){
            fail("Unexpectedly in onResult")
        }

        fun onException( domainException: DomainException){
            fail("Unexpectedly in onException")
        }

        // When
        useCaseExecutor.execute(
            useCase = albumDetailsUseCase,
            value = albumId,
            onResult = ::onResult,
            onException = ::onException
        )

        countDownLatch.await(500, TimeUnit.MILLISECONDS)

        // Then
        assertEquals(expectedCountDown, countDownLatch.count)
    }

    @Test
    fun `Given album ID when execute encounters unknown domain exception then no exception callbacks is fired`() {
        // Given
        val albumDetailsRepository = AlbumDetailsRepositoryThrowsUnknownDomainException()
        val albumDetailsUseCase = AlbumDetailsUseCase(
            albumDetailsRepository,
            coroutineContextProvider
        )

        val albumId = "albumId"
        val useCaseExecutor = UseCaseExecutor( scope )
        val countDownLatch = CountDownLatch(1)
        val expectedCountDown = 0L

        fun onResult(albumDetailsDomainModel: AlbumDetailsDomainModel){
            fail("Unexpectedly in onResult")
        }

        fun onException( domainException: DomainException){
            val actualMessage: String = domainException.message.toString()
            assertTrue("contains message", actualMessage.contains(UNKNOWN_DOMAIN_EXCEPTION_MESSAGE))
            assertTrue("correct type", domainException is UnknownDomainException)
            countDownLatch.countDown()
        }

        // When
        useCaseExecutor.execute(
            useCase = albumDetailsUseCase,
            value = albumId,
            onResult = ::onResult,
            onException = ::onException
        )

        countDownLatch.await(500, TimeUnit.MILLISECONDS)

        // Then
        assertEquals(expectedCountDown, countDownLatch.count)
    }
}




internal class TestDomainException(message: String ): DomainException(Throwable(message)){}
internal class AlbumDetailsRepositoryThrowsException: AlbumDetailsRepository {
    override fun albumDetails(albumId: String): AlbumDetailsDomainModel {
        throw TestDomainException( UseCaseExecutorTest.THROWN_EXCEPTION_MESSAGE)
        return AlbumDetailsDomainModelGenerator().generate()

    }
}

internal class AlbumDetailsRepositoryThrowsCancellationException: AlbumDetailsRepository {
    override fun albumDetails(albumId: String): AlbumDetailsDomainModel {
        throw CancellationException(UseCaseExecutorTest.THROWN_CANCELLATION_EXCEPTION_MESSAGE)
        return AlbumDetailsDomainModelGenerator().generate()

    }
}

internal class AlbumDetailsRepositoryThrowsUnknownDomainException: AlbumDetailsRepository {
    override fun albumDetails(albumId: String): AlbumDetailsDomainModel {
        throw Exception(UseCaseExecutorTest.UNKNOWN_DOMAIN_EXCEPTION_MESSAGE)
        return AlbumDetailsDomainModelGenerator().generate()
    }
}

internal class AlbumDetailsDomainModelGenerator(){
    fun generate(): AlbumDetailsDomainModel{
        return AlbumDetailsDomainModel(
            album = AlbumDomainModel(
                id = "1",
                title = "Keep on Bobbin'",
                artist = "The Mighty Bobbins",
                discs = 2,
                tracks = 19,
                year = 1999,
                imageUrl = "https://en.wikipedia.org/wiki/Bobbin#/media/File:Hua_Nan_sewing_machine_-_06.jpg"
            )
        )
    }
}