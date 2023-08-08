package com.example.fifa

import android.app.Application
import com.example.fifa.di.dataModule
import com.example.fifa.di.domainModule
import com.example.fifa.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class FifaApplication(): Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@FifaApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}