package com.example.homemellow_app.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.homemellow_app.R;
import com.example.homemellow_app.databinding.ActivityMainBinding;
import com.example.homemellow_app.databinding.ActivityStoreBinding;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends Fragment {

    private ActivityStoreBinding mBinding;
    private Handler sliderHandler = new Handler();

    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.activity_store, container, false);

        mBinding = ActivityStoreBinding.inflate(getLayoutInflater());

        List<String> sliderItems = new ArrayList<>();
        sliderItems.add("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/11/10/01/34/pet-5728249_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/12/21/19/05/window-5850628_1280.png");
        sliderItems.add("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg");

        mBinding.vpImageSlider.setAdapter(new SliderAdapter(view.getContext(), sliderItems));
        
        return mBinding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding = null;
    }

}