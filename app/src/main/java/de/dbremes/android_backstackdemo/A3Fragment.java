package de.dbremes.android_backstackdemo;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class A3Fragment extends BaseFragment {
    private static String TAG = "A3Fragment";

    interface A3FragmentListener {
        void onA3FragmentBackButtonClicked();
        void onA3FragmentStartCActivityButtonClicked();
    }
    private A3FragmentListener listener;


    public A3Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof A3FragmentListener) {
            listener = (A3FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement A3FragmentListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a3, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button startCActivityButton = view.findViewById(R.id.startCActivityButton);
        startCActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onA3FragmentStartCActivityButtonClicked();
                }
            }
        });
        // backButton
        Button backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onA3FragmentBackButtonClicked();
                }
            }
        });
    }

}
