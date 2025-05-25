package com.coderpakistan.run.presentation.di

import com.coderpakistan.run.domain.RunningTracker
import com.coderpakistan.run.presentation.active_run.ActiveRunViewModel
import com.coderpakistan.run.presentation.run_overview.RunOverviewViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind

import org.koin.dsl.module

val runPresentationModule = module {

    singleOf(::RunningTracker)

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)

}