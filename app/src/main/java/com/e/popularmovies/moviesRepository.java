package com.e.popularmovies;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class moviesRepository {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String API_KEY = "be44f9cb6ab3f64b9c91466c0ce1160c";
    private static final String Language = "en-us";
    private TMDbApi api;

    private static moviesRepository repository;


    private moviesRepository(TMDbApi api) {
        this.api = api;
    }

    public static moviesRepository getInstance() {
        if (repository ==null){
            Retrofit retrofit  = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            repository = new moviesRepository(retrofit.create(TMDbApi.class));
        }
    return repository;
    }

    public void getMovieS( final onGetMoviesCallback callback){
        api.getMovies(1,API_KEY)
                .enqueue(new Callback<List<Movies>>() {
                    @Override
                    public void onResponse(Call<List<Movies>> call, Response<List<Movies>> response)
                    {
                        if(response.isSuccessful()) {
                            List<Movies> MovieList = response.body();
                            if(MovieList!=null){
                                callback.onSuccess(MovieList);
                            }
                            else callback.onError();
                        }
                        else callback.onError();
                    }
                    @Override
                    public void onFailure(Call<List<Movies>> call, Throwable t) {
                        callback.onError();
                    }
                });


    }
}
