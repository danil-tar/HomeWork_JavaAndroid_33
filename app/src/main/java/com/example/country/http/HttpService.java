package com.example.country.http;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


    public class HttpService {

        public interface CountriesCallback {
            void onSuccess(List<CountryDto> countries);
            void onFailure(Throwable throwable);
        }

        public interface CountryCallback {
            void onSuccess(List<CountryDetailsDto> country);
            void onFailure(Throwable throwable);
        }

        public void getCountries(CountriesCallback callback) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://restcountries.com/v3.1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            CountryApi countryApi = retrofit.create(CountryApi.class);
            countryApi.getCountries().enqueue(new Callback<List<CountryDto>>() {
                @Override
                public void onResponse(Call<List<CountryDto>> call, Response<List<CountryDto>> response) {
                    if (response.isSuccessful()) {
                        List<CountryDto> countries = response.body();
                        callback.onSuccess(countries);
                    } else {
                        callback.onFailure(new Exception("Failed to get countries: " + response.message()));
                    }
                }

                @Override
                public void onFailure(Call<List<CountryDto>> call, Throwable throwable) {
                    callback.onFailure(throwable);
                }
            });
        }

        public void getCountry(String code, CountryCallback callback) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://restcountries.com/v3.1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            System.out.println();
            try {
                CountryApi countryApiDetails = retrofit.create(CountryApi.class);
                System.out.println();
            countryApiDetails.getCountry(code).enqueue(new Callback<List<CountryDetailsDto>>() {

                @Override
                public void onResponse(Call<List<CountryDetailsDto>> call, Response<List<CountryDetailsDto>> response) {
                    System.out.println();
                    if (response.isSuccessful()) {
                        List<CountryDetailsDto> country = response.body();
                        callback.onSuccess(country);
                    } else {
                        callback.onFailure(new Exception("Failed to get country: " + response.message()));
                    }
                }

                @Override
                public void onFailure(Call<List<CountryDetailsDto>> call, Throwable throwable) {

                }
            });
            }catch (Exception e){
                Log.d("Error", e.getMessage());
            }
//
        }
    }


