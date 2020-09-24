package com.example.barcodescanner.utils

import android.annotation.SuppressLint
import android.view.SurfaceHolder
import android.widget.Toast
import com.example.barcodescanner.BarcodeApplication
import com.google.android.gms.vision.CameraSource
import java.lang.Exception
import javax.inject.Inject

class SurfaceCallback @Inject constructor(
    private val application: BarcodeApplication,
    private val cameraSource: CameraSource
) :
    SurfaceHolder.Callback {
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {}

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        cameraSource.stop()
    }

    @SuppressLint("MissingPermission")
    override fun surfaceCreated(holder: SurfaceHolder?) {
        try {
            cameraSource.start(holder)
        } catch (e: Exception) {
            Toast.makeText(application.applicationContext, e.message, Toast.LENGTH_LONG).show()
        }
    }
}