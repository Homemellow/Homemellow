package com.example.homemellow_app.activity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.homemellow_app.R;

public class QnAPostsRVAdapter extends RecyclerView.Adapter<QnAPostsRVAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private String[] title;
    private String[] content;
    private String[] nickname;
    private int[] profile_img;
    private Integer[] time;
    private Integer[] view_cnt;
    private Integer[] comment_cnt;
    private Integer[] like_cnt;


    // Data is passed into the constructor
    public QnAPostsRVAdapter(Context context, String[] title, String[] content, String[] nickname, int[] profile_img, Integer[] time, Integer[] view_cnt, Integer[] comment_cnt, Integer[] like_cnt) {
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.profile_img = profile_img;
        this.time = time;
        this.view_cnt = view_cnt;
        this.comment_cnt = comment_cnt;
        this.like_cnt = like_cnt;
    }

    // Inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.qna_post_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String mtitle = title[position];
        String mcontent = content[position];
        String mnickname = nickname[position];
        Integer mprofile_img = profile_img[position];
        Integer mtime = time[position];
        Integer mview_cnt = view_cnt[position];
        Integer mcomment_cnt = comment_cnt[position];
        Integer mlike_cnt = like_cnt[position];

        holder.l_eventTitle.setText(event_title);
        holder.l_eventPrice.setText(event_price);
        holder.myImageView.setImageResource(store_img);
    }

    // Total number of cells
    @Override
    public int getItemCount() {
        return meventTitle.length;
    }

    // Stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView l_title;
        public TextView l_content;
        public TextView l_nickname;
        public ImageView l_profile_img;
        public TextView l_time;
        public TextView l_view;
        public TextView l_comment;
        public TextView l_like;

        public ViewHolder(View itemView) {
            super(itemView);
            l_title
            l_eventTitle = (TextView)itemView.findViewById(R.id.store_event_title);
            l_eventPrice = (TextView)itemView.findViewById(R.id.store_event_price);
            myImageView = (ImageView)itemView.findViewById(R.id.store_img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClick(view, getAdapterPosition());
        }
    }

    // Convenience method for getting data at click position
    public String getItem(int id) {
        return meventTitle[id];
    }

    // Method that executes your code for the action received
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + getItem(position).toString() + ", which is at cell position " + position);
    }
}