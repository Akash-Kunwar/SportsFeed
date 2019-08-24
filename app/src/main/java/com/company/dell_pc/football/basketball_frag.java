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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class basketball_frag extends Fragment {


    public basketball_frag() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private ProgressBar spinner;
    public void onStart() {
        super.onStart();
        View view =getView();
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview3);

        spinner = (ProgressBar) view.findViewById(R.id.spinner);
        layoutManager =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        spinner.setVisibility(View.VISIBLE);
        getpost();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basketball_frag, container, false);
    }
    private void getpost() {

        final Call<List<FootballPost>> postlist = footballAlleventsget.getPostservice().getpost();
        postlist.enqueue(new Callback<List<FootballPost>>() {
            @Override
            public void onResponse(Call<List<FootballPost>> call, Response<List<FootballPost>> response) {
                spinner.setVisibility(View.GONE);
                if(!response.isSuccessful())
                {
                    Toast.makeText(getContext(),"S1"+"Networking Errors",Toast.LENGTH_SHORT).show();
                }
                else {
                    List<FootballPost> matchpost ;
                    matchpost=response.body();
                    adapter=new footballallmatchadapter(getContext(),matchpost);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<FootballPost>> call, Throwable t) {
                spinner.setVisibility(View.GONE);
                Toast.makeText(getContext(),"Please Connect To The Internet",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
