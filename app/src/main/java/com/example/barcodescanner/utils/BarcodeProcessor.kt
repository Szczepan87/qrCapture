package com.example.barcodescanner.utils

import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode

class BarcodeProcessor(): Detector.Processor<Barcode> {
    override fun release() {}

    override fun receiveDetections(detections: Detector.Detections<Barcode>?) {

    }
}