package com.sample.app.fragment_with_activity_result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sample.app.R;

import static android.app.Activity.RESULT_OK;
import static com.sample.app.fragment_with_activity_result.ActivityWithResult.KEY_RESULT;

public class FragmentWithActivityResult extends Fragment {
    private TextView resultView;
    static final int REQUEST_TEXT = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_with_activity_result, container, false);

        resultView = (TextView) rootView.findViewById(R.id.result);
        bindButton(rootView);

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("activityResult", "activityResult");
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_TEXT:
                    String result = data.getStringExtra(KEY_RESULT);
                    String resultStr = "result is: " + result;
                    resultView.setText(resultStr);
                    break;
            }
        }
    }

    private void bindButton(View rootView) {
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runActivityforResult();
            }
        });
    }

    private void runActivityforResult() {
        Intent intent = new Intent(getActivity(), ActivityWithResult.class);
        startActivityForResult(intent, REQUEST_TEXT);
    }
}