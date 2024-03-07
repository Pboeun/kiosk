package com.example.hanbab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);


        Button noodle1Button = view.findViewById(R.id.noodle1);
        noodle1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("탕수라면");
            }
        });

        Button noodle2Button = view.findViewById(R.id.noodle2);
        noodle2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("부대라면");
            }
        });

        Button noodle3Button = view.findViewById(R.id.noodle3);
        noodle3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("계란라면");
            }
        });

        Button noodle4Button = view.findViewById(R.id.noodle4);
        noodle4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("치즈라면");
            }
        });

        Button noodle5Button = view.findViewById(R.id.noodle5);
        noodle5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("마요라면");
            }
        });

        Button noodle6Button = view.findViewById(R.id.noodle6);
        noodle6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("떡라면");
            }
        });

        Button noodle7Button = view.findViewById(R.id.noodle7);
        noodle7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("얼큰순두부라면");
            }
        });

        Button noodle8Button = view.findViewById(R.id.noodle8);
        noodle8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("얼큰해장라면");
            }
        });

        Button noodle9Button = view.findViewById(R.id.noodle9);
        noodle9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("콩나물뚝배기라면");
            }
        });

        Button noodle10Button = view.findViewById(R.id.noodle10);
        noodle10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("짜계치");
            }
        });

        Button noodle11Button = view.findViewById(R.id.noodle11);
        noodle11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("라볶이");
            }
        });

        Button noodle12Button = view.findViewById(R.id.noodle12);
        noodle12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {addToCart("밥추가");
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
