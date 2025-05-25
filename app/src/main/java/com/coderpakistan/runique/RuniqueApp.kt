package com.coderpakistan.runique

import android.app.Application
import android.content.Context
import com.coderpakistan.auth.data.di.authDataModule
import com.coderpakistan.auth.presentation.BuildConfig
import com.coderpakistan.auth.presentation.di.authViewModelModule
import com.coderpakistan.core.data.di.coreDataModule
import com.coderpakistan.core.database.di.databaseModule
import com.coderpakistan.run.data.di.runDataModule
import com.coderpakistan.run.location.di.locationModule
import com.coderpakistan.run.network.di.networkModule
import com.coderpakistan.run.presentation.di.runPresentationModule
import com.coderpakistan.runique.di.appModule
import com.google.android.play.core.splitcompat.SplitCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}