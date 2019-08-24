package com.company.dell_pc.football;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;



public class postget {


    public static final String url="http://mapps.cricbuzz.com/cbzios/match/";
    public static Interpost postservice=null;
    public static Interpost getPostservice()
    {
        if (postservice==null)
        {
            OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            postservice=retrofit.create(Interpost.class);
        }
        return postservice;
    }






    public interface Interpost
    {
        @GET("livematches")
        Call<Post> getposts();
    }
}
