package com.example.barcodescanner.utils

import android.util.Log
import androidx.core.util.isNotEmpty
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import javax.inject.Inject

class BarcodeProcessor @Inject constructor() : Detector.Processor<Barcode> {
    override fun release() {}

    override fun receiveDetections(detections: Detector.Detections<Barcode>?) {
        if (detections != null && detections.detectedItems.isNotEmpty()) {
            val qrCodes = detections.detectedItems
            val code = qrCodes.valueAt(0)
            Log.d("DETECTED", code.displayValue)
        } else {
            Log.e("DETECTED", "FAILED!")
        }
    }
}