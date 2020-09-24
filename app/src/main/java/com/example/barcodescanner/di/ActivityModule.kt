package com.example.barcodescanner.di

import com.example.barcodescanner.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun mainActivityInjector(): MainActivity
}