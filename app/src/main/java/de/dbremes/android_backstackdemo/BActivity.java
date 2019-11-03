package de.dbremes.android_backstackdemo;

import android.os.Bundle;

public class BActivity extends BaseActivity implements B1Fragment.B1FragmentListener {
    private static String TAG = "BActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        showFragment(new B1Fragment());
    }

    @Override
    public void onB1FragmentBackButtonClicked() {
        startActivity(AActivity.class);
    }

}