package com.moesystems.gamenews.Adapters;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moesystems.gamenews.Entity.New;
import com.moesystems.gamenews.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterNews extends RecyclerView.Adapter<RecycleViewAdapterNews.MyViewHodler> {

    private Context mContext;
    private List<New> noticia;
    private LayoutInflater mInflater;


    public RecycleViewAdapterNews(List<New> noticia) {
        this.noticia = noticia;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view;
       // view =  mInflater.inflate(R.layout.cardview_news,parent,false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_news,parent,false);
        return new MyViewHodler(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        //New mNew = noticia.get(position);
       // holder.title.setText(mNew.getTitle());
        holder.title.setText(noticia.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return noticia.size();
    }

    public static class  MyViewHodler extends RecyclerView.ViewHolder{
        TextView title;
        ImageView gameimg;
        public MyViewHodler(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);

        }
    }
}