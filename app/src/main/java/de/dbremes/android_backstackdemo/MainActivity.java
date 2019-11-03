package de.dbremes.android_backstackdemo;


import android.os.Bundle;

public class MainActivity extends BaseActivity implements
        Main1Fragment.Main1FragmentListener,
        Main2Fragment.Main2FragmentListener,
        Main3Fragment.Main3FragmentListener {
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startWithFragment(new Main1Fragment());
    }

    @Override
    public void onMain1FragmentShowMain2FragmentButtonClicked() {
        showFragment(new Main2Fragment());
    }

    @Override
    public void onMain1FragmentShowMain3FragmentButtonClicked() {
        showFragment(new Main3Fragment());
    }

    @Override
    public void onMain2FragmentBackButtonClicked() {
        onBackPressed();
    }

    @Override
    public void onMain2FragmentStartAActivityButtonClicked() {
        startActivity(AActivity.class);
    }

    @Override
    public void onMain3FragmentBackButtonClicked() {
        onBackPressed();
    }

    @Override
    public void onMain3FragmentStartBActivityButtonClicked() {
        startActivity(BActivity.class);
    }
}
