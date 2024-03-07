package com.example.hanbab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        Button rice1Button = view.findViewById(R.id.rice1);
        rice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("매콤제육덮밥");
            }
        });

        Button rice2Button = view.findViewById(R.id.rice2);
        rice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("목살김치찌개");
            }
        });

        Button rice3Button = view.findViewById(R.id.rice3);
        rice3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("치킨마요덮밥");
            }
        });

        Button rice4Button = view.findViewById(R.id.rice4);
        rice4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("목살슬라이스덮밥");
            }
        });

        Button rice5Button = view.findViewById(R.id.rice5);
        rice5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("새우튀김알밥");
            }
        });

        Button rice6Button = view.findViewById(R.id.rice6);
        rice6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("소금구이정식");
            }
        });

        Button rice7Button = view.findViewById(R.id.rice7);
        rice7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("치킨가라아케카레");
            }
        });

        Button rice8Button = view.findViewById(R.id.rice8);
        rice8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("새우튀김카레");
            }
        });

        Button rice9Button = view.findViewById(R.id.rice9);
        rice9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart("돈카츠카레");
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
