package com.semenov.movie_list.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.semenov.movie_list.R;
import com.semenov.movie_list.adapters.GenresAdapter;

import java.util.ArrayList;
import java.util.List;

public class GenresActivity extends AppCompatActivity {

    List<String> sourcelist;
    List<String> selectedlist;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private GenresAdapter genresAdapter;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        sourcelist=new ArrayList<>();
        sourcelist.add("Комедия");
        sourcelist.add("Триллер");
        sourcelist.add("Драма");
        sourcelist.add("Детектив");
        sourcelist.add("Документальный");
        sourcelist.add("Боевик");

        textView = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button3);

        Intent intent = getIntent();
        String name = intent.getStringExtra("main_key");
        textView.setText(name);

        mRecyclerView=findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        genresAdapter = new GenresAdapter(sourcelist, getApplicationContext(),mRecyclerView);
        mRecyclerView.setAdapter(genresAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MovieListActivity.class);
                List<String> keyList = new ArrayList();
                intent.putExtra("main_key", name);
                for (int i = 0; i < GenresAdapter.selectedValues.size(); i++){
                    keyList.add("key"+i);
                }
                for (int i = 0; i < GenresAdapter.selectedValues.size(); i++){
                    intent.putExtra(keyList.get(i), GenresAdapter.selectedValues.get(i));
                }
                context.startActivity(intent);
            }
        });
    }

    public void getData(View V){
        selectedlist= genresAdapter.listofselectedactivites();
        Log.d("list",selectedlist.toString()) ;}
}