package com.semenov.movie_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Movie_list> movie_lists = new ArrayList<>();

        movie_lists.add(new Movie_list("Фильмы"));
        movie_lists.add(new Movie_list("Сериалы"));
        movie_lists.add(new Movie_list("Мультфильмы"));

        Movie_Adapter movie_adapter = new Movie_Adapter(movie_lists);
        recyclerView.setAdapter(movie_adapter);
    }
}