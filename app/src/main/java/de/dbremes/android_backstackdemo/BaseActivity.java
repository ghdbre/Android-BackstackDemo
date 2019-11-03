package de.dbremes.android_backstackdemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    private static String TAG = "BaseActivity";
    //TODO: targets of Back buttons OK?
    //TODO: write about different events for add() vs. replace() of fragments
    protected void logBackStack() {
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        Log.d(TAG, "Back stack entries:");
        if (supportFragmentManager.getBackStackEntryCount() == 0) {
            Log.d(TAG, "- (no back stack entries)");
        }
        else {
            for (int i = 0; i < supportFragmentManager.getBackStackEntryCount(); i++) {
                Log.d(TAG, "- " + supportFragmentManager.getBackStackEntryAt(i).getName());
            }
        }
    }

    @Override
    public void onBackPressed() {
        final int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        final List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Log.d(TAG, "BaseActivity.onBackPressed(): backStackEntryCount = " + backStackEntryCount
                // fragments.size() will always be 1 because there is 1 visible fragment at a time.
                + "; fragments.size() = " + fragments.size());
        Log.d(TAG, "BaseActivity.onBackPressed(): fragments.get(0) = "
                + fragments.get(0).getClass().getName());
        logBackStack();
    }

    void showFragment(Fragment fragment) {
        Log.d(TAG, "BaseActivity.showFragment(): fragment=" + fragment.getClass().getName());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getClass().getName())
                .commit();
    }

    void startActivity(Class activityClass) {
        Log.d(TAG, "BaseActivity.startActivity(): activityClass=" + activityClass.getName());
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
