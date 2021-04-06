package com.cos.dchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by KPlo on 2018. 10. 28..
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<ChatData> mDataset;
    private String myNickName;

    LayoutInflater layoutInflater;

    public ChatAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_nickname;
        public TextView TextView_msg;
        public View rootView;
        public MyViewHolder(View v) {
            super(v);
            //TextView_nickname = v.findViewById(R.id.TextView_nickname);
            TextView_msg = v.findViewById(R.id.TextView_msg);
            rootView = v;
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    //내 닉네임, 상대 닉네임 구분 String myNickName
    public ChatAdapter(List<ChatData> myDataset, Context context, String myNickName) {
        //{"1","2"}
        mDataset = myDataset;
        this.myNickName = myNickName;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat, parent, false);
//        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.row_chat, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ChatData chat = mDataset.get(position);

        //닉네임, 메세지 가져오기 DTO(데이터 트랜스폼 오브젝트)
        //holder.TextView_nickname.setText(chat.getNickname());
        holder.TextView_msg.setText(chat.getMsg());

        //onBindViewHolder에서 닉네임 비교하고 메세지 정렬
        //내 메세지는 오른쪽, 상대 메세지는 왼쪽
        if(chat.getNickname().equals(this.myNickName)) {
            //holder= layoutInflater.inflate(R.layout.my_msgbox,  false);

            holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            //holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }
        else {
            holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            //holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        //삼항 연산자
        return mDataset == null ? 0 :  mDataset.size();
    }

    public ChatData getChat(int position) {
        return mDataset != null ? mDataset.get(position) : null;
    }

    //채팅할 때마다 새로운 채팅이 덮어씌어지는게 아니라 이전 채팅에 현재 채팅 추가
    public void addChat(ChatData chat) {
        mDataset.add(chat);
        notifyItemInserted(mDataset.size()-1); //갱신
    }

}
