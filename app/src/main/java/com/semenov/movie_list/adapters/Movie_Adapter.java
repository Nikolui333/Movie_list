package com.semenov.movie_list;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Movie_Adapter extends RecyclerView.Adapter<Movie_Adapter.MovieViewHolder> {

    ArrayList<Movie_list> movie_lists;

    public Movie_Adapter(ArrayList<Movie_list> movie_lists) {
        this.movie_lists = movie_lists;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Movie_Adapter.MovieViewHolder holder, int position) {
        holder.textView.setText(movie_lists.get(position).getMovie());
    }

    @Override
    public int getItemCount() {
        return movie_lists.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
        public MovieViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Context context = v.getContext();
                    Intent intent = new Intent(context, GenresActivity.class);
                    intent.putExtra("main_key", movie_lists.get(position).getMovie());
                    context.startActivity(intent);
                }
            });
        }


    }
}
