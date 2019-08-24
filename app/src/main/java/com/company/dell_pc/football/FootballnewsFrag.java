package com.company.dell_pc.football;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballnewsFrag extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ProgressBar progressBar;
    public FootballnewsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_footballnews, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View v=getView();
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview6);
        progressBar=(ProgressBar) v.findViewById(R.id.spinner6);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        progressBar.setVisibility(View.VISIBLE);
        getpost();
    }
    public void getpost()
    {
        final Call<NewsPost> postlist=newspostget.getservice().getfootballitaliapost();
        postlist.enqueue(new Callback<NewsPost>() {
            @Override
            public void onResponse(Call<NewsPost> call, Response<NewsPost> response) {
                progressBar.setVisibility(View.GONE);
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "S1" + "Networking Errors", Toast.LENGTH_SHORT).show();
                } else {
                NewsPost post=response.body();
                    adapter=new newspostadapter(getContext(),post);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<NewsPost> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Please Connect To The Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
