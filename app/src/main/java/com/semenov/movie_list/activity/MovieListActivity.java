package com.semenov.movie_list.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.semenov.movie_list.R;
import com.semenov.movie_list.adapters.GenresAdapter;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    List<String> selectedValues;
    String name;
    List<String> medicationsList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        selectedValues=new ArrayList<>();

        List<String> keyList = new ArrayList();
        Intent intent = getIntent();

        name = intent.getStringExtra("main_key");

        for (int i = 0; i < GenresAdapter.selectedValues.size(); i++){
            keyList.add("key"+i);
        }
        for (int i = 0; i < GenresAdapter.selectedValues.size(); i++){
            selectedValues.add(intent.getStringExtra(keyList.get(i)));
        }
    }
}