package com.coderpakistan.run.data.di

import com.coderpakistan.core.domain.run.SyncRunScheduler
import com.coderpakistan.run.data.CreateRunWorker
import com.coderpakistan.run.data.DeleteRunWorker
import com.coderpakistan.run.data.FetchRunsWorker
import com.coderpakistan.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}