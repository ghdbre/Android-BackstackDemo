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
public class C1Fragment extends Fragment {
    private static String TAG = "C1Fragment";

    interface C1FragmentListener {
        void onC1FragmentBackButtonClicked();
    }
    private C1FragmentListener listener;


    public C1Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof C1FragmentListener) {
            listener = (C1Fragment.C1FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement C1FragmentListener");
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
        return inflater.inflate(R.layout.fragment_c1, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // backButton
        Button backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onC1FragmentBackButtonClicked();
                }
            }
        });
    }
}
