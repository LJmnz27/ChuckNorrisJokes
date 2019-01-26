package org.pursuit.notification_app_hw_jimenez_luis.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.notification_app_hw_jimenez_luis.R;

public class ChuckNorrisViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "image_call";
    private SharedPreferences sharedPreferences;
    private TextView chuckNorrisTextView;
    private Intent intent;

    public ChuckNorrisViewHolder(@NonNull View itemView) {
        super(itemView);
        sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        chuckNorrisTextView = itemView.findViewById(R.id.chuck_norris_text_view);
    }

    public void onBind(String joke) {

    }
}