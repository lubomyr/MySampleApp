package com.sample.app.callback

import android.support.v4.app.Fragment

interface OnAddFragmentListener {
    fun onAddFragment(fragment: Fragment, isAddToBackStack: Boolean)
}
