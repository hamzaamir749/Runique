package com.coderpakistan.analytics.data.di

import com.coderpakistan.analytics.data.RoomAnalyticsRepository
import com.coderpakistan.analytics.domain.AnalyticsRepository
import com.coderpakistan.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}