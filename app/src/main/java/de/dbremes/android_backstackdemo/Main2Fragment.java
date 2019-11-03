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
public class Main2Fragment extends Fragment {
    private static String TAG = "Main2Fragment";

    interface Main2FragmentListener {
        void onMain2FragmentBackButtonClicked();
        void onMain2FragmentStartAActivityButtonClicked();
    }
    private Main2FragmentListener listener;

    public Main2Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Main2FragmentListener) {
            listener = (Main2FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Main2FragmentListener");
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
        return inflater.inflate(R.layout.fragment_main2, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {        // showMain1FragmentButton
        Button startAActivityButton = view.findViewById(R.id.startAActivityButton);
        startAActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onMain2FragmentStartAActivityButtonClicked();
                }
            }
        });
        // backButton
        Button backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onMain2FragmentBackButtonClicked();
                }
            }
        });
    }
}
