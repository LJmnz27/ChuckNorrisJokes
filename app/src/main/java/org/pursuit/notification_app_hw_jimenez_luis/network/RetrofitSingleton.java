package org.pursuit.notification_app_hw_jimenez_luis.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {


        private static Retrofit ourInstance;


        public static Retrofit getInstance() {
            if (ourInstance != null) {
                return ourInstance;
            }
            ourInstance = new Retrofit.Builder()
                    .baseUrl("https://api.chucknorris.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return ourInstance;
        }

        private RetrofitSingleton() {}

}


