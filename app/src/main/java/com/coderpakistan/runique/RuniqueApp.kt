package com.coderpakistan.runique

import android.app.Application
import com.coderpakistan.auth.data.di.authDataModule
import com.coderpakistan.auth.presentation.BuildConfig
import com.coderpakistan.auth.presentation.di.authViewModelModule
import com.coderpakistan.core.data.di.coreDataModule
import com.coderpakistan.runique.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule
            )
        }
    }
}