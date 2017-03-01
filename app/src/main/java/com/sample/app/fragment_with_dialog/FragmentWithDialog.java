package com.sample.app.fragment_with_dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sample.app.R;
import com.sample.app.fragment_with_dialog.dialogs.DialogWithLayout;

public class FragmentWithDialog extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView      = inflater.inflate(R.layout.fragment_with_dialog, container, false);

        Button button1 = (Button) rootView.findViewById(R.id.button_alert_dialog);
        Button button2 = (Button) rootView.findViewById(R.id.button_layout_dialog);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.button_alert_dialog: {
                createAlertDialog();
                break;
            }
            case R.id.button_layout_dialog: {
                startDialog();
                break;
            }
        }
    }

    private void createAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // action when ok pressed
                    }
                });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // action when cancel pressed
                    }
                });
        AlertDialog alertDialog = builder.show();
        alertDialog.setCanceledOnTouchOutside(false);
    }

    private void startDialog() {
        DialogWithLayout dialog = new DialogWithLayout();
        dialog.setTargetFragment(FragmentWithDialog.this, 0);
        dialog.show(getChildFragmentManager(), "Custom Dialog");
    }

}
