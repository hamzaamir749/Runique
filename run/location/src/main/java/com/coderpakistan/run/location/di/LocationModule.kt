package com.coderpakistan.run.location.di

import com.coderpakistan.run.domain.LocationObserver
import com.coderpakistan.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}