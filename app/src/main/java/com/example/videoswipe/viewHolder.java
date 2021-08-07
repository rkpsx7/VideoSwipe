package com.example.videoswipe;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {
    private VideoView videoView;
    private TextView title, details;

    public viewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        videoView = itemView.findViewById(R.id.videoView);
        title = itemView.findViewById(R.id.tv_title);
        details = itemView.findViewById(R.id.tv_video_details);
    }

    void setData(Model model) {
        videoView.setVideoPath(model.getUrl());
        title.setText(model.getTitle());
        details.setText(model.getDetail());
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }
}
