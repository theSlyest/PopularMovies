package com.e.popularmovies;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private moviesAdapter mMoviesAdapter;
    private RecyclerView movieRecyclerView;
    private  moviesRepository moviesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize an instance of the adapter class


        //initializing the recyclerView member variable
        movieRecyclerView = findViewById(R.id.movie_list);

        //create a layout manager for the recycler view
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        movieRecyclerView.setLayoutManager(layoutManager);
        movieRecyclerView.setAdapter(mMoviesAdapter);


        //create an instance of the moviesRepository class to fetch the data from TMDB API
        moviesRepository = com.e.popularmovies.moviesRepository.getInstance();

        moviesRepository.getMovieS(new onGetMoviesCallback() {
            @Override
            public void onSuccess(List<Movies> movies) {
                mMoviesAdapter = new moviesAdapter(movies);
                mMoviesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(),"Error:Check your internet connection",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
