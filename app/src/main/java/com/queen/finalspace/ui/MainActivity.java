package com.queen.finalspace.ui;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.queen.finalspace.Constants;
import com.queen.finalspace.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   // private SharedPreferences mSharedPreferences;
    //private SharedPreferences.Editor mEditor;
    private DatabaseReference mSearchedLocationReference;

    @BindView(R.id.findseasonsButton) Button mFindSeasonButton;
    @BindView(R.id.findEditText) EditText mFindEditText;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

       // mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
      //  mEditor = mSharedPreferences.edit();

        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);

        mFindSeasonButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == mFindSeasonButton) {
            String location = mFindEditText.getText().toString();
            saveLocationToFireBase(location);

            Toast.makeText(MainActivity.this, "Watch Out!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, FindActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }

    public void saveLocationToFireBase(String  location){
        mSearchedLocationReference.setValue(location);
    }

}