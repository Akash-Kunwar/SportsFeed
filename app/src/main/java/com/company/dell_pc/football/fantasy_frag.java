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


public class fantasy_frag extends Fragment {
RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    public fantasy_frag() {
        // Required empty public constructor
    }
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview5);
        progressBar = (ProgressBar) view.findViewById(R.id.spinner5);
        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        progressBar.setVisibility(View.VISIBLE);
        getpost();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fantasy_frag, container, false);
    }
    private void getpost() {

        final Call<NewsPost> postlist =newspostget.getservice().getpost();
        postlist.enqueue(new Callback<NewsPost>() {
            @Override
            public void onResponse(Call<NewsPost> call, Response<NewsPost> response) {
                progressBar.setVisibility(View.GONE);
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "S1" + "Networking Errors", Toast.LENGTH_SHORT).show();
                } else {
                    NewsPost matchpost;
                    matchpost = response.body();
                    adapter = new newspostadapter(getContext(),matchpost);
                    recyclerView.setAdapter(adapter);
                }
            }


            @Override
            public void onFailure(Call<NewsPost> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Please Connect To The Interne", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
