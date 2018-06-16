package com.moesystems.gamenews;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.moesystems.gamenews.API.GamenewsAPI;
import com.moesystems.gamenews.Adapters.RecycleViewAdapterNews;
import com.moesystems.gamenews.Data.Post;
import com.moesystems.gamenews.Data.Remote.Utils;
import com.moesystems.gamenews.Database.GameNewsRoomDatabase;
import com.moesystems.gamenews.Entity.New;
import com.moesystems.gamenews.Repository.GameNewsRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecycleViewAdapterNews adapter2;
    GamenewsAPI api;
    int cant;
    List<New> noticias;
    //New[] noticias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        api= Utils.getAPIService();
        String hola = "xdxdx xdxdxd xdxdxdxdxdx";
        Log.d("xd",hola.replaceAll(" ",""));
        String getToken = getIntent().getStringExtra("TOKEN");
        loadNews(getToken.replaceAll(" ",""));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       // noticias = new ArrayList<>();
        recyclerView =  findViewById(R.id.Recyclerview);
        /////////////////////////////////
//        GameNewsRoomDatabase db = Room.databaseBuilder(getApplicationContext(),GameNewsRoomDatabase.class,"gamenews_database")
//                .allowMainThreadQueries().fallbackToDestructiveMigration().build();

//        List<New> noticias = db.newDAO().getAllNews();

//        db.newDAO().deleteAllNews();
//        New news =  new New("RIP GAMBLING",null,null,"lel","lorem impsum","csgo");
//        db.newDAO().insertNew(news);
//        news =  new New("xdxxdxd",null,null,"lel","lorem impsum","csgo");
//        db.newDAO().insertNew(news);
//        news =  new New(":v:VV:v:VV:v:VV:v",null,null,"lel","lorem impsum","csgo");
//        db.newDAO().insertNew(news);
//        news =  new New("alv",null,null,"lel","lorem impsum","csgo");
//        db.newDAO().insertNew(news);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //3 is the sum of items in one repeated section
                switch (position % 3) {
                    // first item span 6 columns each
                    case 0:
                        return 6;
                    // next 2 items span 3 columns each
                    case 1:
                    case 2:
                        return 3;
                }
                throw new IllegalStateException("internal error");
            }
        });
        Log.d("MainActivity2", getToken);

        recyclerView.setLayoutManager(layoutManager);
       // adapter = new RecycleViewAdapterNews(noticias);
        //recyclerView.setAdapter(adapter);



    }

    public void loadNews(String token){
            api.getNews(token).enqueue(new Callback<List<New>>() {
            @Override
            public void onResponse(Call<List<New>> call, Response<List<New>> response) {
                if(response.isSuccessful()) {
                    noticias= response.body();
                    //mResponseTv.setText(news[0].getTitle());
                    recyclerView.setAdapter(new RecycleViewAdapterNews(noticias));


                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    Log.d("RESPONSE CODE: ", ""+statusCode);
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<New>> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
                Log.d("Message ",t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
