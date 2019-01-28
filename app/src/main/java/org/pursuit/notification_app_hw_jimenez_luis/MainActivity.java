package org.pursuit.notification_app_hw_jimenez_luis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.pursuit.notification_app_hw_jimenez_luis.controller.ChuckNorrisAdapter;
import org.pursuit.notification_app_hw_jimenez_luis.model.Joke;
import org.pursuit.notification_app_hw_jimenez_luis.network.ChuckNorrisService;
import org.pursuit.notification_app_hw_jimenez_luis.network.RetrofitSingleton;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private  static final String TAG = "Jokes_all";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.jokes_recycler_view);
        Retrofit retrofit = RetrofitSingleton.getInstance();
        ChuckNorrisService chuckNorrisService = retrofit.create(ChuckNorrisService.class);
        Call<Joke> jokeCall = chuckNorrisService.getJokeId("joke");
        jokeCall.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                recyclerView.setAdapter(new ChuckNorrisAdapter(Collections.singletonList(response.body().getCategory().toString())));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {

            }
        });
    }
}
