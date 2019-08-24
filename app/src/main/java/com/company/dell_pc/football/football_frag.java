package com.company.dell_pc.football;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class football_frag extends Fragment {


    public football_frag() {
        // Required empty public constructor
    }
    private ArrayList<Employee> employeeList;
    private ProgressBar pDialog;
    private RecyclerView recyclerView;
    private EmployeesAdapter eAdapter;

    public void onStart() {
        super.onStart();
        final View view =getView();
        ApiService api = RetroClient.getApiService();
        pDialog=(ProgressBar)view.findViewById(R.id.spinner01);
        pDialog.setVisibility(view.VISIBLE);

        /**
         * Calling JSON
         */
        Call<EmployeeList> call = api.getMyJSON();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                //Dismiss Dialog

                pDialog.setVisibility(view.GONE);

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    employeeList = response.body().getEmployee();
                    recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
                    eAdapter = new EmployeesAdapter(employeeList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
                }
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                pDialog.setVisibility(view.GONE);
                Toast.makeText(getContext(), "Please Connect To The Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_football_frag, container, false);
    }

}
