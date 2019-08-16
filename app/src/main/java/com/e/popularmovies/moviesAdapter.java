package com.e.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class moviesAdapter extends RecyclerView.Adapter<moviesAdapter.movieViewHolder>  {
    private ImageView movieImage;
    private TextView movieTitle, movieGenre, movieYear, movieRating;

    public moviesAdapter(){}



    @NonNull
    @Override
    public movieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =  parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.movie_item_layout, parent, false);
        movieViewHolder viewHolder = new movieViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull movieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }


    //create inner viewHolder class
    public class movieViewHolder extends RecyclerView.ViewHolder{



        public movieViewHolder(@NonNull View itemView) {
            super(itemView);
            //get the itemView ids here
            //movieImage = itemView.findViewById(R.id.movie_image);
            //movieTitle = itemView.findViewById(R.id.movie_title);
            //movieGenre = itemView.findViewById(R.id.movie_genre);
            //movieYear = itemView.findViewById(R.id.movie_year);

        }
    }
}
