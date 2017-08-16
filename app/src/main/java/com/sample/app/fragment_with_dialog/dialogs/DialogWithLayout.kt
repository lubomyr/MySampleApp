package com.sample.app.fragment_with_dialog.dialogs

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import com.sample.app.R

class DialogWithLayout : DialogFragment(), View.OnClickListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        // Get the layout inflater
        val inflater = activity.layoutInflater
        builder.setCancelable(false)
        val view = inflater.inflate(R.layout.dialog_layout, null)

        val okButton = view.findViewById(R.id.ok_button) as Button
        val cancelButton = view.findViewById(R.id.cancel_button) as Button
        okButton.setOnClickListener(this)
        cancelButton.setOnClickListener(this)

        builder.setView(view)

        return builder.create()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.cancel_button -> dismiss()
            R.id.ok_button -> dismiss()
        }
    }
}
