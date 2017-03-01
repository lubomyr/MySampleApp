package com.sample.app.callback;

import android.support.v4.app.Fragment;

public interface OnAddFragmentListener {
    void onAddFragment(Fragment fragment, boolean isAddToBackStack);
}
