package com.example.homemellow_app.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.homemellow_app.R;
import com.example.homemellow_app.databinding.ActivityStoreBinding;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends Fragment {
    private ActivityStoreBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.activity_store, container, false);

        String[] data = {"홈가드닝", "홈파밍", "홈트레이닝", "홈베이킹", "홈쿡", "홈바", "홈파티", "홈바캉스", "홈시네마", "홈뷰티", "인테리어", "공예"};
        int[] imgList = {R.drawable.asset_1, R.drawable.asset_2, R.drawable.asset_3, R.drawable.asset_6, R.drawable.asset_12, R.drawable.asset_14, R.drawable.asset_8, R.drawable.asset_10, R.drawable.asset_11, R.drawable.asset_9, R.drawable.top_cart, R.drawable.top_cart};

        String[] store_recommand_title = {"[10% + 카드할인] 방짜유기 + 보자기 세트", "[10% + 카드할인] 방짜유기 + 보자기 세트"};
        String[] store_recommand_price = {"쇼킹딜가 36000원 ~", "쇼킹딜가 36000원 ~"};
        int[] store_recommand_image = {R.drawable.banner, R.drawable.banner};

        String[] store_event_title = {"[10% + 카드할인] 방짜유기 + 보자기 세트", "[10% + 카드할인] 방짜유기 + 보자기 세트"};
        String[] store_event_price = {"쇼킹딜가 36000원 ~", "쇼킹딜가 36000원 ~"};
        int[] store_event_image = {R.drawable.banner, R.drawable.banner};

        mBinding = ActivityStoreBinding.inflate(getLayoutInflater());

        List<String> sliderItems = new ArrayList<>();
        sliderItems.add("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/11/10/01/34/pet-5728249_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2020/12/21/19/05/window-5850628_1280.png");
        sliderItems.add("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg");
        sliderItems.add("https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg");

        mBinding.vpImageSlider.setAdapter(new StoreSliderRVAdapter(view.getContext(), sliderItems));

        mBinding.storeRv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mBinding.storeRv.setAdapter(new StoreCategoryRVAdapter(getContext(), data, imgList));

        mBinding.storeRecommand.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.storeRecommand.setAdapter((new StoreRecommandRVAdapter(getContext(), store_recommand_title, store_recommand_price, store_recommand_image)));

        mBinding.storeEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.storeEvent.setAdapter((new StoreEventRVAdapter(getContext(), store_event_title, store_event_price, store_event_image)));

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