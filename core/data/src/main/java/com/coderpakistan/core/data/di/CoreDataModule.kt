package com.coderpakistan.core.data.di

import com.coderpakistan.core.data.auth.EncryptedSessionStorage
import com.coderpakistan.core.data.networking.HttpClientFactory
import com.coderpakistan.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}