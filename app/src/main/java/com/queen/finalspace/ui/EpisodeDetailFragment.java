package com.queen.finalspace.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.queen.finalspace.model.Episode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Button;

import com.queen.finalspace.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EpisodeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EpisodeDetailFragment extends Fragment {

    @BindView(R.id.episodeImageView) ImageView mImageView;
    @BindView(R.id.detailEpisodeName) TextView mEpisodeName;
    @BindView(R.id.detailEpisodeWriter) TextView mEpisodeWriter;
    @BindView(R.id.detailEpisodeDirector) TextView mEpisodeDirector;

    @BindView(R.id.like) TextView mLikeTextView;
    @BindView(R.id.unlike) TextView mUnlikeTextView;
    private Episode episode;



    public EpisodeDetailFragment() {
        // Required empty public constructor
    }


    public static EpisodeDetailFragment newInstance(Episode episode) {

        EpisodeDetailFragment episodeDetailFragment = new EpisodeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("Episode", Parcels.wrap(episode));
        episodeDetailFragment.setArguments(args);
        return episodeDetailFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        episode = Parcels.unwrap(getArguments().getParcelable("Episode"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_episode_detail,container,false);
        ButterKnife.bind(this, view);
        Picasso.get().load(R.drawable.images).into(mImageView);
        mEpisodeName.setText("Episode Name: "+episode.getName());
        mEpisodeWriter.setText("Episode Writer: " + episode.getWriter());
        mEpisodeDirector.setText("Episode Director :" + episode.getDirector());
        return view;
    }
}