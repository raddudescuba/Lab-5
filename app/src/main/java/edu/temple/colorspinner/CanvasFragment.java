package edu.temple.colorspinner;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends android.support.v4.app.Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    View layout;
    public CanvasFragment() {
        // Required empty public constructor
    }

    public static CanvasFragment newInstance(String color) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
        setColor(mParam1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout=inflater.inflate(R.layout.fragment_canvas,container,false);
        return layout;
    }

    private void setColor(String color){
        layout.setBackgroundColor(Color.parseColor(color));
    }



}
