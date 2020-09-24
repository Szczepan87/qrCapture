package com.example.barcodescanner.di

import android.content.Context
import com.example.barcodescanner.BarcodeApplication
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.barcode.BarcodeDetector
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CameraModule {

    @Provides
    @Singleton
    fun providesCameraSource(application: BarcodeApplication, detector: BarcodeDetector): CameraSource =
        CameraSource.Builder(application.applicationContext, detector).setAutoFocusEnabled(true).build()

    @Provides
    @Singleton
    fun providesDetector(application: BarcodeApplication): BarcodeDetector =
        BarcodeDetector.Builder(application.applicationContext).build()
}