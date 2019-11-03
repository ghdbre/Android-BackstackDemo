package de.dbremes.android_backstackdemo;


import android.os.Bundle;

public class AActivity extends BaseActivity implements
        A1Fragment.A1FragmentListener,
        A2Fragment.A2FragmentListener,
        A3Fragment.A3FragmentListener {
    private static String TAG = "AActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        showFragment(new A1Fragment());
    }

    @Override
    public void onA1FragmentShowA2FragmentButtonClicked() {
        showFragment(new A2Fragment());
    }

    @Override
    public void onA1FragmentShowA3FragmentButtonClicked() {
        showFragment(new A3Fragment());
    }

    @Override
    public void onA2FragmentBackButtonClicked() {
        showFragment(new A1Fragment());
    }

    @Override
    public void onA2FragmentStartBActivityButtonClicked() {
        startActivity(BActivity.class);
    }

    @Override
    public void onA3FragmentBackButtonClicked() {
        showFragment(new A1Fragment());
    }

    @Override
    public void onA3FragmentStartCActivityButtonClicked() {
        startActivity(CActivity.class);
    }
}
