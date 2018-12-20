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

    //Declaar API
    private APIRest apirest;
    //Declarar Retrofit
    private Retrofit retrofit;
    //Declarar/Crear Recycler
    private Recycler recycler;
    private RecyclerView recyclerView;
    //Declarar EXTRA MESSAGE
    public String message;
    //Declarar textview y imageview que aparecen en el layout para pasar valor
    private TextView numrepostxt;
    private TextView numfollowstxt;
    ImageView activityProfileIVInternet;
    //Declarar spinner de cargando donde estamos esperando los datos
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recycler = new Recycler(this);
        recyclerView.setAdapter(recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);



        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Waiting for the server");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        //Create API
        apirest= APIRest.createAPIRest();

        getCities();
    }


    public void getCities() {

        Call<List<Cities>> citiesCall = apirest.cities("11");
        citiesCall.enqueue(new Callback<List<Cities>>() {
            @Override
            public void onResponse(Call<List<Cities>> call, Response<List<Cities>> response) {
                if (response.isSuccessful()){
                    //Creamos lista ususario con los datos de List<User> response en new lIst (tipo body), y ahí iremos añadiendo los diferentes usuarios con sus datos
                    List<Cities> newList =response.body();
                    recycler.addCities(newList);
                    for(int i = 0; i < newList.size(); i++) {
                        Log.i("Cities: " + newList.get(i).getNom(), response.message());
                        Log.i("Size of the list: " +newList.size(), response.message());
                    }
                    //Si va bien desaparece progressDialog
                    progressDialog.hide();

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
                            .setPositiveButton("OK", ((dialog, which) -> finish() ));
                    //Crea
                    android.support.v7.app.AlertDialog alertDialog=alertDialogBuilder.create();
                    //Enseña
                    alertDialog.show();
                }
            }

            //Alert dialog, titulo meensaje, parametros adicionales error servidor
            @Override
            public void onFailure(Call<List<Cities>> call, Throwable t) {
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
