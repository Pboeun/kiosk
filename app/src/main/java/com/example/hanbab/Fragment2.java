package com.example.hanbab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);


        Button pork1Button = view.findViewById(R.id.pork1);
        pork1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("김돈까스");
            }
        });

        Button pork2Button = view.findViewById(R.id.pork2);
        pork2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("쫄돈까스");
            }
        });

        Button pork3Button = view.findViewById(R.id.pork3);
        pork3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("떡치돈");
            }
        });

        return view;
    }

    private void addToCart(String itemName) {
        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.addToCart(itemName);
        }
    }
}
