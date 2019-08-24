package com.company.dell_pc.football;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class newspostget {


private static final String url="https://newsapi.org/v2/";
    private static Interpost postservice=null;
    public static Interpost getservice()
    {
        if(postservice==null)
        {
            OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder();
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .build();
            postservice=retrofit.create(Interpost.class);
        }
        return postservice;
    }





    public interface Interpost{
        @GET("top-headlines?sources=espn&apiKey=ac812829f0244883a782d25a4ea02b61")
        Call<NewsPost> getpost();
        @GET("top-headlines?sources=football-italia&apiKey=15728fac166347df9636f714e4af10b6")
        Call<NewsPost> getfootballitaliapost();

    }
}
