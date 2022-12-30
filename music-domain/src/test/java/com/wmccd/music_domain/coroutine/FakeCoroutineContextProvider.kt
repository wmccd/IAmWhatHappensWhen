package com.wmccd.music_domain.coroutine

import com.wmccd.music_domain.clean_architecture.coroutine.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class FakeCoroutineContextProvider: CoroutineContextProvider {
    override val main: CoroutineContext = Dispatchers.Unconfined
    override val io: CoroutineContext = Dispatchers.Unconfined
}