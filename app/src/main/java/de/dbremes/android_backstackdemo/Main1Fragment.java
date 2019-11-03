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
public class Main1Fragment extends BaseFragment {
    private static String TAG = "Main1Fragment";

    interface Main1FragmentListener {
        void onMain1FragmentShowMain2FragmentButtonClicked();
        void onMain1FragmentShowMain3FragmentButtonClicked();
    }
    private Main1FragmentListener listener;

    public Main1Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Main1FragmentListener) {
            listener = (Main1FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Main1FragmentListener");
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
        return inflater.inflate(R.layout.fragment_main1, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // showMain2FragmentButton
        Button showMain2FragmentButton = view.findViewById(R.id.showMain2FragmentButton);
        showMain2FragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onMain1FragmentShowMain2FragmentButtonClicked();
                }
            }
        });
        // showMain3FragmentButton
        Button showMain3FragmentButton = view.findViewById(R.id.showMain3FragmentButton);
        showMain3FragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onMain1FragmentShowMain3FragmentButtonClicked();
                }
            }
        });
    }
}
