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
public class A1Fragment extends BaseFragment {
    private static String TAG = "A1Fragment";

    interface A1FragmentListener {
        void onA1FragmentShowA2FragmentButtonClicked();
        void onA1FragmentShowA3FragmentButtonClicked();
    }
    private A1FragmentListener listener;


    public A1Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof A1FragmentListener) {
            listener = (A1FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement A1FragmentListener");
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
        return inflater.inflate(R.layout.fragment_a1, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // showA2FragmentButton
        Button showA2FragmentButton = view.findViewById(R.id.showA2FragmentButton);
        showA2FragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onA1FragmentShowA2FragmentButtonClicked();
                }
            }
        });
        // showA3FragmentButton
        Button showA3FragmentButton = view.findViewById(R.id.showA3FragmentButton);
        showA3FragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onA1FragmentShowA3FragmentButtonClicked();
                }
            }
        });
    }
}
