package com.moesystems.gamenews;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moesystems.gamenews.API.GamenewsAPI;
import com.moesystems.gamenews.Data.Post;
import com.moesystems.gamenews.Data.Remote.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    GamenewsAPI  api;
    EditText txtUser,txtPass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser =  findViewById(R.id.txtUser);
        txtPass =  findViewById(R.id.txtPass);
        btnLogin =  findViewById(R.id.btn_login);

        api = Utils.getAPIService();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUser.getText().toString().trim();
                String pass = txtPass.getText().toString().trim();
                if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
                    sendPost(user, pass);
                }
            }
        });
    }
    public void sendPost(String user, String pass) {
        api.savePost(user, pass).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {

                    showResponse(response.body().toString());
                    if (response.body().toString()!=null){
                        Intent intent =  new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                    Log.i("LELELELELedede", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("LELELELEL", "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {
        Log.d("LEL", "is null: "+(response==null));
    }
}
