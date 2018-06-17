package com.moesystems.gamenews.Adapters;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moesystems.gamenews.Entity.New;
import com.moesystems.gamenews.NewsActivity;
import com.moesystems.gamenews.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterNews extends RecyclerView.Adapter<RecycleViewAdapterNews.MyViewHolder> {

    private Context mContext;
    private List<New> noticia;
    private New[] noticia2;
    private LayoutInflater mInflater;


    public RecycleViewAdapterNews(Context mContext,List<New> noticia) {
        this.mContext = mContext;
        this.noticia = noticia;
    }
    public RecycleViewAdapterNews(New[] noticia2) {
        this.noticia2 = noticia2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view;
       // view =  mInflater.inflate(R.layout.cardview_news,parent,false);
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_news,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.title.setText(noticia.get(position).getTitle());
//        holder.body.setText(noticia.get(position).getBody());
        holder.desc.setText(noticia.get(position).getDescription());

        Picasso.get()
                .load(noticia.get(position).getCoverImage())
                .fit()
                .into(holder.gameimg);
        holder.cardview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,NewsActivity.class);
                intent.putExtra("title",noticia.get(position).getTitle());
                intent.putExtra("juego",noticia.get(position).getGame());
                intent.putExtra("body",noticia.get(position).getBody());
                intent.putExtra("img",noticia.get(position).getCoverImage());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        //return noticia2.length;
        return noticia.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView gameimg;
        CardView cardview;
        TextView desc,body,game;
        public MyViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            gameimg =  itemView.findViewById(R.id.img_game);
            cardview =  itemView.findViewById(R.id.new_cardview);
            desc = itemView.findViewById(R.id.desc);
            body =  itemView.findViewById(R.id.body);
            //game =  itemView.findViewById(R.id.juego);


        }
    }
    public void noticiaaas (List<New> news){
        noticia = news;

    }
}
