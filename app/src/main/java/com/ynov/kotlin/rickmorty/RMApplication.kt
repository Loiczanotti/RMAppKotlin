package com.ynov.kotlin.rickmorty

import android.app.Application
import com.ynov.kotlin.rickmorty.presentation.di.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RMApplication : Application(){

    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@RMApplication)
            // modules
            modules(myModule)

        }
    }
}