package com.coderpakistan.auth.data.di

import com.coderpakistan.auth.data.AuthRepositoryImpl
import com.coderpakistan.auth.data.EmailPatternValidator
import com.coderpakistan.auth.domain.AuthRepository
import com.coderpakistan.auth.domain.PatternValidator
import com.coderpakistan.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}