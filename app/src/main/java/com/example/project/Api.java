package com.example.project;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface Api {
    String BASE_URL="http://10.0.2.2/Water/";
    @GET("Api.php")
    Call<List<WaveLevel>>getLevel();
}
