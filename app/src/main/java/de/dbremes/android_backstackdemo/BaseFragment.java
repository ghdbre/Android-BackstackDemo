package de.dbremes.android_backstackdemo;

import androidx.fragment.app.Fragment;

class BaseFragment extends Fragment {
    private static String TAG = "BaseFragment";

    BaseActivity getBaseActivity() {
        return (BaseActivity)getActivity();
    }
}
