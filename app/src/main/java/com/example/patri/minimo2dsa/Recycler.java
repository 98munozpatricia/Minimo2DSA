package com.example.patri.minimo2dsa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {



    private List<Element> CitiesList;
    private Context context;



    //Asign the text TextView to the text1 in the layout
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cityIDE;
        private TextView cityNameView;
        private ImageView photoCity;

        public ViewHolder(View v) {
            super(v);
            cityNameView = v.findViewById(R.id.followerNameView);
            photoCity = v.findViewById(R.id.escudo);
            cityIDE = v.findViewById(R.id.ide_view);

        }
    }

    //Constructor
    public Recycler(List<Element> list) {
        CitiesList=list;
    }


    @Override
    public Recycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        context=parent.getContext();
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Recycler.ViewHolder holder, int position) {

        Element element = CitiesList.get(position);
        holder.cityNameView.setText(element.getMunicipiNom());
        holder.cityIDE.setText(element.getIne());
        Picasso.with(context).load(element.getMunicipiEscut()).into(holder.photoCity);


    }

    @Override
    public int getItemCount() {
        return CitiesList.size();
    }
}



