package com.moesystems.gamenews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsActivity extends AppCompatActivity {
    TextView juego,titulo,body;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        juego =  findViewById(R.id.juego);
        titulo =  findViewById(R.id.titulo);
        body =  findViewById(R.id.body);
        img = findViewById(R.id.thumbnail);

        Intent intent =  getIntent();
        String title =  intent.getExtras().getString("title");
        String game =  intent.getExtras().getString("juego");
        String body =  intent.getExtras().getString("body");
        String img = intent.getExtras().getString("img");




        juego.setText(game);
        titulo.setText(title);
        this.body.setText(body);
        Picasso.get().load(img).into(this.img);


    }
}
