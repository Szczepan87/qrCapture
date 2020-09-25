package com.example.barcodescanner.di

import com.example.barcodescanner.ui.QRFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun qrFragmentInjector(): QRFragment
}