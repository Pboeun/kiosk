package com.example.hanbab;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hanbab.MainActivity;
import com.example.hanbab.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private List<String> cartItems;
    private CartAdapter cartAdapter; // 변경된 부분: CartAdapter 사용
    private int orderNumber = 0; // 주문 번호 변수
    private static final String PREFS_NAME = "CartActivityPrefs";
    private static final String KEY_ORDER_NUMBER = "orderNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItems = new ArrayList<>();
        cartAdapter = new CartAdapter(this, cartItems); // 변경된 부분: CartAdapter 생성

        ListView cartListView = findViewById(R.id.cartListView);
        cartListView.setAdapter(cartAdapter); // 변경된 부분: CartAdapter 설정

        // MainActivity로부터 장바구니 목록을 전달받습니다.
        ArrayList<String> receivedCartItems = getIntent().getStringArrayListExtra("cartItems");
        if (receivedCartItems != null) {
            cartItems.addAll(receivedCartItems);
            cartAdapter.notifyDataSetChanged();
        }

        Button orderButton = findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOrderConfirmationDialog(); // 주문 확인 다이얼로그 표시
            }
        });

        // SharedPreferences에서 주문 번호 불러오기
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        orderNumber = prefs.getInt(KEY_ORDER_NUMBER, 0);

        updateOrderNumber(); // 주문 번호 초기화
    }

    public void addToCart(String itemName) {
        cartItems.add(itemName);
        cartAdapter.notifyDataSetChanged();
    }

    private class CartAdapter extends ArrayAdapter<String> {
        private final Activity context;

        public CartAdapter(Activity context, List<String> items) {
            super(context, R.layout.cartitem, items);
            this.context = context;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View itemView = inflater.inflate(R.layout.cartitem, null, true);

            TextView itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            Button deleteButton = itemView.findViewById(R.id.deleteButton);

            itemNameTextView.setText(cartItems.get(position));
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDeleteButtonClick(position);
                }
            });

            return itemView;
        }
    }

    public void onDeleteButtonClick(int position) {
        cartItems.remove(position);
        cartAdapter.notifyDataSetChanged();
    }

    private void updateOrderNumber() {
        orderNumber++; // 주문 번호 증가
        TextView orderNumberTextView = findViewById(R.id.orderNumberTextView);
        orderNumberTextView.setText("주문 번호: " + orderNumber);

        // 주문 번호 저장
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_ORDER_NUMBER, orderNumber);
        editor.apply();
    }

    private void showOrderConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("주문 완료" +"(주문번호:" + orderNumber +")")
                .setMessage("주문이 완료되었습니다! 결제는 카운터에서 부탁드립니다.")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 주문이 완료되었으므로 장바구니를 초기화하거나 필요한 처리를 수행할 수 있습니다.
                        cartItems.clear();
                        cartAdapter.notifyDataSetChanged();
                        // 추가적인 처리를 수행하고자 한다면 여기에 구현합니다.
                        Intent intent = new Intent(CartActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 이전 액티비티 스택 제거
                        startActivity(intent);
                        finish(); // 현재 액티비티 종료
                    }
                })
                .setCancelable(false)
                .show();
    }
}
