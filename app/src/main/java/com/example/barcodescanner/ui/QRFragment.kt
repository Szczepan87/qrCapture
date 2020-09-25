package com.example.barcodescanner.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.barcodescanner.R
import com.example.barcodescanner.databinding.FragmentQRBinding
import com.example.barcodescanner.utils.BarcodeProcessor
import com.example.base.BaseFragment
import com.google.android.gms.vision.barcode.BarcodeDetector
import kotlinx.android.synthetic.main.fragment_q_r.*
import javax.inject.Inject

class QRFragment : BaseFragment<FragmentQRBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_q_r

    private val requestCodeCameraPermission = 1001

    @Inject
    lateinit var detector: BarcodeDetector

    @Inject
    lateinit var surfaceCallback: SurfaceHolder.Callback

    @Inject
    lateinit var processor: BarcodeProcessor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkForPermission()
    }

    private fun checkForPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            askForCameraPermission()
        } else {
            setupControls()
        }
    }

    private fun setupControls() {
        cameraView.holder.addCallback(surfaceCallback)
        detector.setProcessor(processor)
    }

    private fun askForCameraPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.CAMERA),
            requestCodeCameraPermission
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == requestCodeCameraPermission && grantResults.isNotEmpty()) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupControls()
            } else {
                Toast.makeText(requireContext(), "Permission denied!", Toast.LENGTH_LONG).show()
            }
        }
    }
}