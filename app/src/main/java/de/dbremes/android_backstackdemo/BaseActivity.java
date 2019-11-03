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

    protected void logBackStack() {
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        final int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
        Log.d(TAG, "Back stack entries:");
        if (backStackEntryCount == 0) {
            Log.d(TAG, "- (no back stack entries)");
        }
        else {
            for (int i = 0; i < backStackEntryCount; i++) {
                Log.d(TAG, "- " + supportFragmentManager.getBackStackEntryAt(i).getName());
            }
        }
    }

    @Override
    public void onBackPressed() {
        final int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        final List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Log.d(TAG, "onBackPressed(): backStackEntryCount = " + backStackEntryCount
                // fragments.size() will always be 1 because there is 1 visible fragment at a time.
                + "; fragments.size() = " + fragments.size());
        if (fragments.size() > 0) {
            Log.d(TAG, "onBackPressed(): fragments.get(0) = "
                    + fragments.get(0).getClass().getName());
        }
        logBackStack();
        super.onBackPressed();
    }

    void showFragment(Fragment fragment) {
        Log.d(TAG, "showFragment(): fragment=" + fragment.getClass().getName());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commit();
    }

    void startActivity(Class activityClass) {
        Log.d(TAG, "startActivity(): activityClass=" + activityClass.getName());
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    public void startWithFragment(BaseFragment fragment) {
        final List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Log.d(TAG, "startWithFragment(): fragments.size() = " + fragments.size()
                + " (" + fragment.getClass().getName() + " for " + this + ")");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment, fragment.getClass().getName())
                // Adding an activity's 1st fragment to the back stack would result in an empty
                // (activity) screen when the system back button is pressed on that back stack entry.
                //.addToBackStack(fragment.getClass().getName())
                .commit();
    }
}
