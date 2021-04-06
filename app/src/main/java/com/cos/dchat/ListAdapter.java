package com.cos.dchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private ArrayList<ChatData> arrayList;
    private Context context;

    //알트인서트
    public ListAdapter(ArrayList<ChatData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chat_list_item, parent, false);
        ListViewHolder holder= new ListViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        //.chat_list의 이미지 받아오기
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_id.setText(arrayList.get(position).getId());
        holder.tv_pw.setText(String.valueOf(arrayList.get(position).getPw()));//
        holder.tv_username.setText(arrayList.get(position).getUsername());

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_profile;
        TextView tv_id;
        TextView tv_pw;
        TextView tv_username;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile= itemView.findViewById(R.id.iv_profile);
            this.tv_id= itemView.findViewById(R.id.tv_id);
//            this.tv_pw= itemView.findViewById(R.id.tv_pw);
            this.tv_username= itemView.findViewById(R.id.tv_username);
        }
    }
}
