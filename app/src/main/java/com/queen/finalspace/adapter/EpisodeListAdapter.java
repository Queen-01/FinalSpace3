package com.queen.finalspace.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.queen.finalspace.R;
import com.queen.finalspace.model.Episode;
import com.queen.finalspace.ui.EpisodeDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

public class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeListAdapter.EpisodeViewHolder> {

    private List<Episode> episodesList;
    private Context mContext;


    public EpisodeListAdapter(Context context,List<Episode> episodesList) {
        mContext = context;
        this.episodesList = episodesList;
    }

    @Override
    public EpisodeViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.find_list,parent,false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EpisodeListAdapter.EpisodeViewHolder holder, int position) {
        holder.airDate.setText("Air Date: " +episodesList.get(position).getAirDate());
       // holder.episodeCharacters.setText("Characters: " +episodesList.get(position).getCharacters());
        holder.episodeDirector.setText("Directors: " +episodesList.get(position).getDirector());
        holder.episodeName .setText("Episode Name: " +episodesList.get(position).getName());
        Picasso.get().load(R.drawable.images).into(holder.episodeImageView);

    }

    @Override
    public int getItemCount() {
        return episodesList.size();
    }

    public class EpisodeViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView episodeImageView;
        TextView episodeName,episodeDirector, airDate, episodeCharacters;

        public EpisodeViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            episodeImageView = itemView.findViewById(R.id.episodeImageView);
            episodeName = itemView.findViewById(R.id.episodeName);
            episodeDirector = itemView.findViewById(R.id.episodeDirector);
            airDate = itemView.findViewById(R.id.airDate);
            //episodeCharacters = itemView.findViewById(R.id.episodeCharacters);
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, EpisodeDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("episode", Parcels.wrap(episodesList));
            mContext.startActivity(intent);
        }
    }
}
