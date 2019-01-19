package org.pursuit.notification_app_hw_jimenez_luis.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

        /*Retrofit wrapper class makes sure only one instance of this class exits*/
        private static Retrofit ourInstance;

        /*In order to access this singleton you much reference this public method
         * this returns the only retrofit instance you will need
         * this helps makes sure our memory usage is minimal and not garbage collected*/
        public static Retrofit getInstance() {
            if (ourInstance != null) {
                return ourInstance;
            }
            ourInstance = new Retrofit.Builder()
                    .baseUrl("https://dog.ceo/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return ourInstance;
        }

        private RetrofitSingleton() {}
        /*Makes sure that default constructor isn't public
         * Constructor should be private
         * Field should be private
         * and makes sure if instance is not null then create it otherwise
         * return the instance if its
         * already created*/
}


