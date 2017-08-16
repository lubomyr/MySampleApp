package com.sample.app.fragment_with_dialog

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.sample.app.R
import com.sample.app.fragment_with_dialog.dialogs.DialogWithLayout

class FragmentWithDialog : Fragment(), View.OnClickListener {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_dialog, container, false)

        val button1 = rootView.findViewById(R.id.button_alert_dialog) as Button
        val button2 = rootView.findViewById(R.id.button_layout_dialog) as Button

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)

        return rootView
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_alert_dialog -> {
                createAlertDialog()
            }
            R.id.button_layout_dialog -> {
                startDialog()
            }
        }
    }

    private fun createAlertDialog() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Title")
        builder.setMessage("Message")
        builder.setPositiveButton("Ok"
        ) { dialog, which ->
            // action when ok pressed
        }
        builder.setNegativeButton("Cancel"
        ) { dialog, which ->
            // action when cancel pressed
        }
        val alertDialog = builder.show()
        alertDialog.setCanceledOnTouchOutside(false)
    }

    private fun startDialog() {
        val dialog = DialogWithLayout()
        dialog.setTargetFragment(this@FragmentWithDialog, 0)
        dialog.show(childFragmentManager, "Custom Dialog")
    }

}
