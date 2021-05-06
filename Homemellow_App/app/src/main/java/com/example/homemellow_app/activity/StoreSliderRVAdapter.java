package com.example.homemellow_app.activity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homemellow_app.databinding.SlideItemBinding;

import java.util.List;

public class StoreSliderRVAdapter extends RecyclerView.Adapter<StoreSliderRVAdapter.SliderViewHolder> {

    private static final String TAG = "SliderAdapter";

    private Context mContext;
    private List<String> sliderItems;

    public StoreSliderRVAdapter(Context context, List<String> sliderImage) {
        mContext = context;
        this.sliderItems = sliderImage;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(SlideItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.bind(sliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {

        private SlideItemBinding mBinding;

        public SliderViewHolder(SlideItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bind(String sliderItem) {
            try {
                Glide.with(mContext).load(sliderItem).into(mBinding.imageSlider);
            } catch (Exception e) {
                Log.d(TAG, "ERROR: " + e.getMessage());
            }
        }
    }

}