package com.example.patri.minimo2dsa;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends LoginActivity {


    private APIRest apirest;
    private Retrofit retrofit;
    private Recycler recycler;
    private RecyclerView recyclerView;
    public String message;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setAdapter(recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));







        //Create API
        apirest= APIRest.createAPIRest();

        getCities();
    }


    public void getCities() {

        Call <Cities> citiesCall = apirest.cities("1","11");
        citiesCall.enqueue(new Callback<Cities>() {
            @Override
            public void onResponse(Call<Cities> call, Response<Cities> response) {
                if (response.isSuccessful()){
                    Cities cities = (Cities) response.body();
                    recyclerView.setAdapter(new Recycler(cities.getElements()));


                }
                else {
                    Log.e("No api connection", response.message());

                    //Alert dialog
                    //Establece
                    android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);

                    alertDialogBuilder
                            .setTitle("Error")
                            .setMessage(response.message())
                            .setCancelable(false)
                            .setPositiveButton("OK", ((dialog, which) -> finish()));
                    //Crea
                    android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();
                    //Enseña
                    alertDialog.show();
                }

            }

            @Override
            public void onFailure(Call<Cities> call, Throwable t) {
                Log.e("No api connection", t.getMessage());

                //Alert dialog
                //Establece
                android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);

                alertDialogBuilder
                        .setTitle("Error")
                        .setMessage(t.getMessage())
                        .setCancelable(false)
                        .setPositiveButton("OK", ((dialog, which) -> finish() ));
                //Crea
                android.support.v7.app.AlertDialog alertDialog=alertDialogBuilder.create();
                //Enseña
                alertDialog.show();

            }
        });

    }



}
