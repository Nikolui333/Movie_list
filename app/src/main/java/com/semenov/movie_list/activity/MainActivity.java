package com.semenov.movie_list.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.semenov.movie_list.adapters.Main_Adapter;
import com.semenov.movie_list.MainList;
import com.semenov.movie_list.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<MainList> movie_lists = new ArrayList<>();

        movie_lists.add(new MainList("Фильмы"));
        movie_lists.add(new MainList("Сериалы"));
        movie_lists.add(new MainList("Мультфильмы"));

        Main_Adapter movie_adapter = new Main_Adapter(movie_lists);
        recyclerView.setAdapter(movie_adapter);
    }
}