package com.teksystem.hackathon.Adapters;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.teksystem.hackathon.Models.TopicsModel;
import com.teksystem.hackathon.R;
import com.teksystem.hackathon.TopicDetailActivity;

import java.util.List;

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.TopicViewHolder> {
    private List<TopicsModel> topics;

    public class TopicViewHolder extends RecyclerView.ViewHolder {
        public TextView topicname;
        public ImageView imageView;
        public CoordinatorLayout taptopic;
        public TopicViewHolder(View view) {
            super(view);
            topicname = (TextView)view.findViewById(R.id.desc_tweet);
            imageView = view.findViewById(R.id.image_tweet);
            taptopic = view.findViewById(R.id.tab_topic);
        }
    }

    public TopicsAdapter(List<TopicsModel> topics) {
        this.topics = topics;
    }

    @Override
    public TopicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentview = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_tweet, parent, false);

        return new TopicViewHolder(contentview);
    }

    @Override
    public void onBindViewHolder(TopicViewHolder holder, int position) {
        TopicsModel topicsModel = topics.get(position);
        holder.topicname.setText(topicsModel.getTopic_name());
        Glide.with(holder.imageView.getContext()).load(topicsModel.getTopic_img()).into(holder.imageView);
        holder.taptopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(), TopicDetailActivity.class);
                in.putExtra("");
                view.getContext().startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

}
