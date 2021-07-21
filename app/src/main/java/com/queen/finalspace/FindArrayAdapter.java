package com.queen.finalspace;

import android.content.Context;
import android.widget.ArrayAdapter;

public class FindArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mSeasons;
    private String[] mChapters;

    public FindArrayAdapter(Context mContext, int resources, String[] mSeasons, String[] mChapters){
        super(mContext, resources);
        this.mContext = mContext;
        this.mSeasons = mSeasons;
        this.mChapters = mChapters;

    }

    @Override
    public Object getItem(int position){
        String season = mSeasons[position];
        String chapter = mChapters[position];
        return String.format("%s \nServes great : %s",season, chapter);
    }
    @Override
    public int getCount(){
        return mSeasons.length;
    }

}
