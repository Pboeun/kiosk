package com.example.hanbab;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> cartItems;
    private ArrayAdapter<String> cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartItems = new ArrayList<>();
        cartAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);

        ListView cartListView = findViewById(R.id.cartListView);
        cartListView.setAdapter(cartAdapter);

        Button riceButton = findViewById(R.id.rice);
        riceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                intent.putStringArrayListExtra("cartItems", new ArrayList<>(cartItems));
                startActivity(intent);
            }
        });

        Button bagButton = findViewById(R.id.bag);
        bagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                intent.putStringArrayListExtra("cartItems", new ArrayList<>(cartItems));
                startActivity(intent);
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new Fragment1());
        ft.commit();
    }

    public void fragment1(View v){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new Fragment1());
        ft.commit();
    }

    public void fragment2(View v){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new Fragment2());
        ft.commit();
    }

    public void fragment3(View v){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new Fragment3());
        ft.commit();
    }

    public void fragment4(View v){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new Fragment4());
        ft.commit();
    }

    public void addToCart(String foodName) {
        cartItems.add(foodName);
        cartAdapter.notifyDataSetChanged();
        String message = foodName + " 가(이) 장바구니에 담겼습니다.";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}