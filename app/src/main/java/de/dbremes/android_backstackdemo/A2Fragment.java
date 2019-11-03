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
public class A2Fragment extends BaseFragment {
    private static String TAG = "A2Fragment";

    interface A2FragmentListener {
        void onA2FragmentBackButtonClicked();
        void onA2FragmentStartBActivityButtonClicked();
    }
    private A2FragmentListener listener;

    public A2Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof A2FragmentListener) {
            listener = (A2FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement A2FragmentListener");
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
        return inflater.inflate(R.layout.fragment_a2, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {        // showMain1FragmentButton
        Button startBActivityButton = view.findViewById(R.id.startBActivityButton);
        startBActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onA2FragmentStartBActivityButtonClicked();
                }
            }
        });
        // backButton
        Button backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onA2FragmentBackButtonClicked();
                }
            }
        });
    }
}
