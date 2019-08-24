package com.company.dell_pc.football;


import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class footballAlleventsget {

    public static final String url="https://apifootball.com/api/";
    public static Interpost postservice=null;
    public static Interpost getPostservice()
    {
        if(postservice==null)
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

    public interface Interpost {
        //  @GET("?action=get_predictions&from=2019-01-01&to=2019-12-12&APIkey=ff8d3cca0c80200bfff582a4fe57f8a2bcf2d21ddab399a3aee9ba7b9d804294")
        @GET("?action=get_predictions&from=2019-01-26&to=2020-01-18&APIkey=ff8d3cca0c80200bfff582a4fe57f8a2bcf2d21ddab399a3aee9ba7b9d804294")
        Call<List<FootballPost>> getpost();

    }
}