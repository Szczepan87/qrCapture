package com.example.barcodescanner.di

import com.example.barcodescanner.BarcodeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FragmentModule::class,
        ActivityModule::class,
        CameraModule::class,
        AndroidInjectionModule::class]
)
interface ApplicationComponent : AndroidInjector<BarcodeApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BarcodeApplication): Builder

        fun build(): ApplicationComponent
    }

}