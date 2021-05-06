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

public class StoreEventRVAdapter extends RecyclerView.Adapter<StoreEventRVAdapter.ViewHolder> {

    private String[] meventTitle = new String[0];
    private String[] meventPrice = new String[0];
    private LayoutInflater mInflater;
    private int[] mImgList;

    // Data is passed into the constructor
    public StoreEventRVAdapter(Context context, String[] eventTitle, String[] eventPrice, int[] imgList) {
        this.mInflater = LayoutInflater.from(context);
        this.meventTitle = eventTitle;
        this.meventPrice = eventPrice;
        this.mImgList = imgList;
    }

    // Inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.store_event, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String event_title = meventTitle[position];
        String event_price = meventPrice[position];
        Integer store_img = mImgList[position];

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
        public TextView l_eventTitle;
        public TextView l_eventPrice;
        public ImageView myImageView;

        public ViewHolder(View itemView) {
            super(itemView);
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