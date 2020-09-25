package com.example.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment

abstract class BaseFragment<TViewBinging : ViewDataBinding> : DaggerFragment() {

    abstract val layoutId: Int

    private var innerBinding: TViewBinging? = null
    val binding: TViewBinging
        get() = innerBinding ?: throw IllegalStateException("Binging was not initialized!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        innerBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    fun navigateTo(navDirections: NavDirections) {
        findNavController().navigate(navDirections)
    }

    fun navigateBack() {
        findNavController().popBackStack()
    }

    fun hideKeyboard() {
        val imm =
            requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = requireActivity().currentFocus
        if (view != null) {
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } else {
            return
        }
    }
}