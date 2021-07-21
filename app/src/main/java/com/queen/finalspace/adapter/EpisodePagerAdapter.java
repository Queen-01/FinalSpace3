package com.queen.finalspace.adapter;

import android.support.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.queen.finalspace.model.Episode;
import com.queen.finalspace.ui.EpisodeDetailFragment;

import java.util.List;

public class EpisodePagerAdapter extends FragmentPagerAdapter {
    private List<Episode> mEpisodes;

    public EpisodePagerAdapter(@NonNull FragmentManager fm, int behavior, List<Episode> results) {
        super(fm, behavior);
        mEpisodes = results;
    }

    @Override
    public Fragment getItem(int position) {
        return EpisodeDetailFragment.newInstance(mEpisodes.get(position));
    }

    @Override
    public int getCount() {
        return mEpisodes.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mEpisodes.get(position).getDirector();
    }
}
