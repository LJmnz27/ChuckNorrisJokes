package org.pursuit.notification_app_hw_jimenez_luis.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import org.pursuit.notification_app_hw_jimenez_luis.R;
import org.pursuit.notification_app_hw_jimenez_luis.SecondActivity;
import org.pursuit.notification_app_hw_jimenez_luis.controller.ChuckNorrisAdapter;
import org.pursuit.notification_app_hw_jimenez_luis.model.Joke;
import org.pursuit.notification_app_hw_jimenez_luis.model.JokeCategory;
import org.pursuit.notification_app_hw_jimenez_luis.network.ChuckNorrisService;
import org.pursuit.notification_app_hw_jimenez_luis.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChuckNorrisViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "image_call";
    private SharedPreferences sharedPreferences;
    private TextView chuckNorrisTextView;
    private Intent intent;

    public ChuckNorrisViewHolder(@NonNull View itemView) {
        super(itemView);
        sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        chuckNorrisTextView = itemView.findViewById(R.id.chuck_norris_text_view);
        // Woah. You don't need to getSharedPreferences twice.
        sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG,Context.MODE_PRIVATE);
    }

    public void onBind(final String joke) {
    chuckNorrisTextView.setText(joke);
    itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent = new Intent(itemView.getContext(), SecondActivity.class);
            // You're putting Extra twice.
            intent.putExtra("joke", joke);

            if (sharedPreferences.contains((joke + "joke"))) {
                intent.putExtra("joke", sharedPreferences.getString((joke + "joke"), null));
                itemView.getContext().startActivity(intent);
            }else {

                // What's the purpose of making another retrofit call?
                // Shouldn't your joke object contain everything you need?
                Retrofit retrofit = RetrofitSingleton.getInstance();
                ChuckNorrisService chuckNorrisService = retrofit.create(ChuckNorrisService.class);
                Call<Joke> jokeCall = chuckNorrisService.getJokeId(joke);
                jokeCall.enqueue(new Callback<Joke>() {
                    @Override
                    public void onResponse(Call<Joke> call, Response<Joke> response) {
                        intent.putExtra("image", response.body().getCategory().toString());
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(joke + "_joke", (String) response.body().getCategory());
                        editor.apply();
                        itemView.getContext().startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Joke> call, Throwable t) {

                    }
                });
            }
        }
    });
    }
}