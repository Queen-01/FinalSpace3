package com.queen.finalspace.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

//import com.example.finalspace.adapter.FindSpaceListAdapter;
import com.queen.finalspace.Constants;
import com.queen.finalspace.R;
import com.queen.finalspace.adapter.EpisodeListAdapter;
import com.queen.finalspace.model.Episode;
import com.queen.finalspace.service.FinalSpaceClient;

import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    EpisodeListAdapter mAdapter;
    List<Episode> EpisodeList;

    //private SharedPreferences mSharedPreferences;
    //private String mRecentAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        ButterKnife.bind(this);



       // mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
       // mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCE_LOCATION_KEY, null);
       //   String location = mRecentAddress;
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        fetchEpisodeList();
    }

    public void fetchEpisodeList(){
        progressBar.setVisibility(View.VISIBLE);
        FinalSpaceClient.getRetrofitClient().getEpisode().enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                if (response.isSuccessful() && response.body() != null);
                EpisodeList = response.body();
                progressBar.setVisibility(View.GONE);
                mAdapter = new EpisodeListAdapter(FindActivity.this,EpisodeList);
                recyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(FindActivity.this, "Error occured" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}