package com.cos.dchat;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Chat_List_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ChatData> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        //recyclerView= findViewById(R.id.recycler_view); //아이디 연결
        recyclerView.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList= new ArrayList<>(); //ChatData 객체를 담을 어레이 리스트(어댑터쪽으로)

        database= FirebaseDatabase.getInstance();// firebase DB 연동

        //여기서 "User"는 dchat-6d352-default-rtdb: null의 User데이터베이스
        databaseReference= database.getReference("ChatData_01");// DB 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //firebase DB의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    ChatData chatData = snapshot.getValue(ChatData.class); // 만들어뒀던 User 객체에 데이터를 담는다.
                    arrayList.add(chatData); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged();// 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //DB를 가져오던 중 에러 발생 시
                Log.e("Chat_List_Activity", String.valueOf(databaseError.toException()));// 에러를 출력

            }
        });

        //ListAdapter의 생성자에 접근
         adapter= new ListAdapter(arrayList,this);
         recyclerView.setAdapter(adapter);// 리사이클러뷰의 어댑터에 연결




    }
}
