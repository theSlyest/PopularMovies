package com.e.popularmovies;

import java.util.List;

public interface onGetMoviesCallback {

    void onSuccess(List<Movies> movies);
    void onError();
}
