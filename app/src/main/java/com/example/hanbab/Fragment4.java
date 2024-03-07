package com.example.hanbab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);


        Button drink1Button = view.findViewById(R.id.drink1);
        drink1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("피크닉");
            }
        });

        Button drink2Button = view.findViewById(R.id.drink2);
        drink2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("콜라");
            }
        });

        Button drink3Button = view.findViewById(R.id.drink3);
        drink3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("사이다");
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
