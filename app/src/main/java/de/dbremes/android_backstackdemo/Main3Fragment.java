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
public class Main3Fragment extends Fragment {
    private static String TAG = "Main3Fragment";

    interface Main3FragmentListener {
        void onMain3FragmentBackButtonClicked();
        void onMain3FragmentStartBActivityButtonClicked();
    }
    private Main3FragmentListener listener;


    public Main3Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Main3FragmentListener) {
            listener = (Main3FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Main3FragmentListener");
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
        return inflater.inflate(R.layout.fragment_main3, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button startBActivityButton = view.findViewById(R.id.startBActivityButton);
        startBActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onMain3FragmentStartBActivityButtonClicked();
                }
            }
        });
        // backButton
        Button backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onMain3FragmentBackButtonClicked();
                }
            }
        });
    }

}
