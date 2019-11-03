package de.dbremes.android_backstackdemo;

import android.os.Bundle;

public class CActivity extends BaseActivity implements C1Fragment.C1FragmentListener {
    private static String TAG = "CActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        startWithFragment(new C1Fragment());
    }

    @Override
    public void onC1FragmentBackButtonClicked() {
        startActivity(AActivity.class);
    }
}
