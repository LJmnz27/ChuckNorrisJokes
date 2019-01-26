package org.pursuit.notification_app_hw_jimenez_luis.network;

import org.pursuit.notification_app_hw_jimenez_luis.model.Joke;
import org.pursuit.notification_app_hw_jimenez_luis.model.JokeCategory;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ChuckNorrisService {


    @GET("api.chucknorris.io/jokes/categories")
    Call<JokeCategory> getJokeCategories();

    @GET("https://api.chucknorris.io/jokes/random?category={category}")
    Call<Joke> getJokeId(@Path("category") String jokeId);
}

