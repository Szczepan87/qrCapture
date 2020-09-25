package com.example.base

import android.util.LayoutDirection
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    abstract val layoutId: Int

    abstract fun navigateTo(navDirection: LayoutDirection)
}