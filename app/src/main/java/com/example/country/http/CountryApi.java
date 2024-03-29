package com.example.country.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CountryApi {
    @GET("all?fields=cca2,name,flags")
    Call<List<CountryDto>> getCountries();

    @GET("alpha")
    Call<List<CountryDetailsDto>> getCountry(@Query("codes") String code);
}

