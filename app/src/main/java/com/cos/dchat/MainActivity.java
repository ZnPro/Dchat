package com.cos.dchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list_item);



        LinearLayout ll_start = findViewById(R.id.chat_list_profile);

        ll_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    //클릭 2번해야하는 안좋은 방법, 실행도 잘 안됨
//    public void mOnClick(View view){
//
//        LinearLayout linearLayout = findViewById(R.id.chat_list_item_profile);
//
//
//        linearLayout.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, ChatActivity.class);
//            startActivity(intent);
//            finish();
//        });
//
//        Button btn_start = findViewById(R.id.start_btn_set_location);
//
//        btn_start.setOnClickListener(v -> {
//            Intent intent2 = new Intent(MainActivity.this, ChatActivity.class);
//            startActivity(intent2);
//            finish();
//        });
//
//        ImageView ib_back = findViewById(R.id.iv_back);
//
//        ib_back.setOnClickListener(v -> {
//            Intent intent3 = new Intent(MainActivity.this, ChatActivity.class);
//            startActivity(intent3);
//            finish();
//        });
//
//
//    }


}