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

public class StoreCategoryRVAdapter extends RecyclerView.Adapter<StoreCategoryRVAdapter.ViewHolder> {

    private String[] mData = new String[0];
    private LayoutInflater mInflater;
    private int[] mImgList;

    // Data is passed into the constructor
    public StoreCategoryRVAdapter(Context context, String[] data, int[] imgList) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mImgList = imgList;
    }

    // Inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.store_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String store_text = mData[position];
        Integer store_img = mImgList[position];
        holder.myTextView.setText(store_text);
        holder.myImageView.setImageResource(store_img);
    }

    // Total number of cells
    @Override
    public int getItemCount() {
        return mData.length;
    }

    // Stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;
        public ImageView myImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView)itemView.findViewById(R.id.store_text);
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
        return mData[id];
    }

    // Method that executes your code for the action received
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + getItem(position).toString() + ", which is at cell position " + position);
    }
}