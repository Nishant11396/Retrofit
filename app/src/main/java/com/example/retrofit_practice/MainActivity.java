package com.example.retrofit_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textview, textView2, textView3;
    RecyclerView recycler;

    String url = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.recycleView);

//        textview = findViewById(R.id.hello);
//        textView2 = findViewById(R.id.tv_name);
//        textView3 = findViewById(R.id.last_name);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Myapi api = retrofit.create(Myapi.class);

        Call<List<Model>> call = api.getdata();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call,Response<List<Model>> response) {
                List<Model> data = response.body();

                recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));


                Myadapter myadapter = new Myadapter(data,MainActivity.this);
                recycler.setAdapter(myadapter);
//                int i;
//                for (i = 0; i < data.size(); i++) {
//                    textview.append(String.valueOf(data.get(i).getId())+"\n");
//                    textView2.append(data.get(i).getEmail()+"\n");
//                    textView3.append(data.get(i).getName()+"\n\n\n");
//
//                }
////                textview.setText("");
//                textView2.setText("");
//                textView3.setText("");

            }

                @Override
                public void onFailure (Call < List < Model >> call, Throwable t){

                }
            });


        }
    }