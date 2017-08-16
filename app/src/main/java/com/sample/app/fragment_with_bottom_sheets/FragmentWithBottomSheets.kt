package com.sample.app.fragment_with_bottom_sheets

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.sample.app.R

class FragmentWithBottomSheets : Fragment(), View.OnClickListener {
    private var mBottomSheetBehavior: BottomSheetBehavior<*>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_bottom_sheets, container, false)

        val bottomSheet = rootView.findViewById(R.id.bottom_sheet)
        val button1 = rootView.findViewById(R.id.button_1) as Button
        val button2 = rootView.findViewById(R.id.button_2) as Button
        val button3 = rootView.findViewById(R.id.button_3) as Button

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        mBottomSheetBehavior!!.peekHeight = 300
        mBottomSheetBehavior!!.state = BottomSheetBehavior.STATE_COLLAPSED

        mBottomSheetBehavior!!.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior!!.peekHeight = 0
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })

        return rootView
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_1 -> {
                mBottomSheetBehavior!!.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            R.id.button_2 -> {
                val bottomSheetDialogFragment = TutsPlusBottomSheetDialogFragment()
                bottomSheetDialogFragment.show(activity.supportFragmentManager, bottomSheetDialogFragment.tag)
            }
        }
    }


}
