package com.queen.finalspace.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

//import com.example.finalspace.adapter.FindSpaceListAdapter;
import com.queen.finalspace.Constants;
import com.queen.finalspace.R;
import com.queen.finalspace.adapter.EpisodeListAdapter;
import com.queen.finalspace.model.Episode;
import com.queen.finalspace.service.FinalSpaceClient;

import java.security.PublicKey;
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

    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;
    private String mRecentAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCE_LOCATION_KEY, null);
//        if (mRecentAddress !=null){
//            fetchEpisodeList(mRecentAddress);
//        }
//        Intent intent = getIntent();
//        String location = intent.getStringExtra("location");

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        fetchEpisodeList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                addToSharedPreferences(location);
                fetchEpisodeList();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String location) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return  super.onOptionsItemSelected(item);
    }
    //@Override
    public void onFailure(Call<List<Episode>> call, Throwable t) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(FindActivity.this, "Error occured" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
    private void addToSharedPreferences(String location){
        mEditor.putString(Constants.PREFERENCE_LOCATION_KEY, location).apply();
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