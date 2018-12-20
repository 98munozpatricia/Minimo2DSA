package com.example.patri.minimo2dsa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class Recycler  {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private List<Element> elements;

    private void getCities() {
        APIRest apiRest = new APIRest() {
            @Override
            public Call<List<Cities>> getCities(String username) {
                return null;
            }
        };
/*
        Call<Cities> callCitiesList = dibaAPI.cities("1","11");
        callCitiesList.enqueue(new Callback<Cities>() {
            @Override
            public void onResponse(Call<Cities> call, Response<Cities> response) {
                int statusCode = response.code();
                if (response.isSuccessful()) {
                    Cities cities = response.body();
                    recyclerView.setAdapter(new
                            CitiesRecyclerViewAdapter(cities.getElements(), mListener));
                    showProgress(false);
                }
            }
            @Override
            public void onFailure(Call<Cities> call, Throwable t) {
...
            }
        });

    public void addFollowers(List<User> followersList) {
        data.addAll(followersList);
        notifyDataSetChanged();
    }

    //Asign the text TextView to the text1 in the layout
    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private TextView followerNameView;
        private ImageView photoFollower;

        public ViewHolder(View v) {
            super(v);
            followerNameView = v.findViewById(R.id.followerNameView);
            photoFollower = v.findViewById(R.id.photoFollower);
            linearLayout = v.findViewById(R.id.linearLayout);
        }
    }

    //Constructor
    public Recycler(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    @Override
    public Recycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follower, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Recycler.ViewHolder holder, int position) {
        User userData = data.get(position);
        holder.followerNameView.setText(userData.login);

        Picasso.with(context).load(userData.avatar_url).into(holder.photoFollower);

        holder.linearLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProfileFollowerActivity.class);
            TextView editText = v.findViewById(R.id.followerNameView);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    */
    }


}