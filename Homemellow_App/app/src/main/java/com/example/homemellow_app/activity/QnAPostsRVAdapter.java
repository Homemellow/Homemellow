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
    private int[] post_img;


    // Data is passed into the constructor
    public QnAPostsRVAdapter(Context context, String[] title, String[] content, String[] nickname, int[] profile_img, Integer[] time, Integer[] view_cnt, Integer[] comment_cnt, Integer[] like_cnt, int[] post_img) {
        this.mInflater = LayoutInflater.from(context);
        this.title = title;
        this.content = content;
        this.nickname = nickname;
        this.profile_img = profile_img;
        this.time = time;
        this.view_cnt = view_cnt;
        this.comment_cnt = comment_cnt;
        this.like_cnt = like_cnt;
        this.post_img = post_img;
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
        Integer mpost_img = post_img[position];

        holder.l_title.setText(mtitle);
        holder.l_content.setText(mcontent);
        holder.l_nickname.setText(mnickname);
        holder.l_profile_img.setImageResource(mprofile_img);
        holder.l_time.setText(Integer.toString(mtime));
        holder.l_view.setText(Integer.toString(mview_cnt));
        holder.l_comment.setText(Integer.toString(mcomment_cnt));
        holder.l_like.setText(Integer.toString(mlike_cnt));
        holder.l_post_img.setImageResource(mpost_img);
    }

    // Total number of cells
    @Override
    public int getItemCount() {
        return title.length;
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
        public ImageView l_post_img;

        public ViewHolder(View itemView) {
            super(itemView);
            l_title = (TextView)itemView.findViewById(R.id.qna_title);
            l_content = (TextView)itemView.findViewById(R.id.qna_content_preview);
            l_nickname = (TextView)itemView.findViewById(R.id.qna_nickname);
            l_profile_img = (ImageView)itemView.findViewById(R.id.qna_profile_img);
            l_time = (TextView)itemView.findViewById(R.id.qna_time);
            l_view = (TextView)itemView.findViewById(R.id.qna_view_cnt);
            l_comment = (TextView)itemView.findViewById(R.id.qna_comment_cnt);
            l_like = (TextView)itemView.findViewById(R.id.qna_like_cnt);
            l_post_img = (ImageView)itemView.findViewById(R.id.qna_post_img);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClick(view, getAdapterPosition());
        }
    }

    // Convenience method for getting data at click position
    public String getItem(int id) {
        return title[id];
    }

    // Method that executes your code for the action received
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + getItem(position).toString() + ", which is at cell position " + position);
    }
}