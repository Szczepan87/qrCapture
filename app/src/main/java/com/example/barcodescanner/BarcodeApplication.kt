package com.example.barcodescanner

import android.app.Application
import com.example.barcodescanner.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BarcodeApplication : DaggerApplication() {

    private lateinit var component: AndroidInjector<BarcodeApplication>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        if (!::component.isInitialized) {
            component = DaggerApplicationComponent.builder().application(this).build()
        }
        return component
    }

}