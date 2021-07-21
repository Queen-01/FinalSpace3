package com.queen.finalspace.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.queen.finalspace.R;
import com.queen.finalspace.adapter.EpisodePagerAdapter;
import com.queen.finalspace.model.Episode;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EpisodeDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    private EpisodePagerAdapter adapterViewPager;
    List<Episode> mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);
        ButterKnife.bind(this);

        mResult = Parcels.unwrap(getIntent().getParcelableExtra("episode"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new EpisodePagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mResult);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}