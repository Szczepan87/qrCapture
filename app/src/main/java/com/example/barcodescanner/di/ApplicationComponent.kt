package com.example.barcodescanner.di

import com.example.barcodescanner.BarcodeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [ActivityModule::class, CameraModule::class, AndroidInjectionModule::class])
interface ApplicationComponent : AndroidInjector<BarcodeApplication>{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BarcodeApplication): Builder

        fun build():ApplicationComponent
    }
}