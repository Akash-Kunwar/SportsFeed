package com.company.dell_pc.football;

        import retrofit2.Call;
        import retrofit2.http.GET;

public interface ApiService {


    @GET("tatti")
    Call<EmployeeList> getMyJSON();
}