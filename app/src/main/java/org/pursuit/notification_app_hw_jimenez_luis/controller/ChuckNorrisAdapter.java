package org.pursuit.notification_app_hw_jimenez_luis.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.notification_app_hw_jimenez_luis.R;
import org.pursuit.notification_app_hw_jimenez_luis.view.ChuckNorrisViewHolder;

import java.util.List;

/**
 * Command+Option+L
 */
public class ChuckNorrisAdapter extends RecyclerView.Adapter<ChuckNorrisViewHolder> {
    List<String> jokesList;     // Should be private;

    public  ChuckNorrisAdapter(List<String> jokesList){
        this.jokesList =jokesList;
    }

    @NonNull
    @Override
    public ChuckNorrisViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chuck_norris_item_view,viewGroup, false);
        return new ChuckNorrisViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuckNorrisViewHolder chuckNorrisViewHolder, int i) {
        chuckNorrisViewHolder.onBind(jokesList.get(i));
    }

    // Your recyclerview is never going to show anything if you tell it to show 0 items.
    @Override
    public int getItemCount() {
        return 0;
    }
}
