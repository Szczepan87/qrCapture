package com.example.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<TViewBiding : ViewDataBinding> : DaggerAppCompatActivity() {

    abstract val layoutId: Int

    private var innerBinding: TViewBiding? = null
    val binding: TViewBiding
        get() = innerBinding ?: throw IllegalStateException("Binging was not initialized!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        innerBinding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
    }
}