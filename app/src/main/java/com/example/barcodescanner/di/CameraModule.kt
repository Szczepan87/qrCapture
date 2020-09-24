package com.example.barcodescanner.di

import android.content.Context
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.barcode.BarcodeDetector
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CameraModule {

    @Provides
    @Singleton
    fun providesCameraSource(context: Context, detector: BarcodeDetector) =
        CameraSource.Builder(context, detector).setAutoFocusEnabled(true).build()

    @Provides
    @Singleton
    fun providesDetector(context: Context) = BarcodeDetector.Builder(context).build()
}