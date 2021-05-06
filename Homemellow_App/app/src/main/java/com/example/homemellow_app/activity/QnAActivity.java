package com.example.homemellow_app.activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.homemellow_app.R;
import com.example.homemellow_app.activity.QnAPostsRVAdapter;
import com.example.homemellow_app.databinding.ActivityQnaBinding;

public class QnAActivity extends Fragment {
    private ActivityQnaBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        String[] title = {"홈가드닝", "홈파밍", "홈트레이닝", "홈베이킹", "홈쿡", "홈바", "홈파티", "홈바캉스", "홈시네마", "홈뷰티", "인테리어", "공예"};
        String[] content = {"홈가드닝", "홈파밍", "홈트레이닝", "홈베이킹", "홈쿡", "홈바", "홈파티", "홈바캉스", "홈시네마", "홈뷰티", "인테리어", "공예"};
        String[] nickname = {"홈가드닝", "홈파밍", "홈트레이닝", "홈베이킹", "홈쿡", "홈바", "홈파티", "홈바캉스", "홈시네마", "홈뷰티", "인테리어", "공예"};
        int[] profile_img = {R.drawable.asset_1, R.drawable.asset_2, R.drawable.asset_3, R.drawable.asset_6, R.drawable.asset_12, R.drawable.asset_14, R.drawable.asset_8, R.drawable.asset_10, R.drawable.asset_11, R.drawable.asset_9, R.drawable.top_cart, R.drawable.top_cart};
        Integer[] time = {1912, 1911, 1910, 1909, 1908, 1907, 1906, 1905, 1904, 1903, 1902, 1901};
        Integer[] view_cnt = {1, 2, 3, 4, 4, 2, 3, 7, 6, 7, 4, 9};
        Integer[] comment_cnt = {8, 4, 5, 9, 4, 7, 10, 5, 5, 2, 1, 6};
        Integer[] like_cnt = {1, 2, 1, 3, 3, 4, 6, 8, 5, 3, 5, 13};
        int[] post_img = {R.drawable.kakao_login, R.drawable.asset_2, R.drawable.asset_3, R.drawable.asset_6, R.drawable.asset_12, R.drawable.asset_14, R.drawable.asset_8, R.drawable.asset_10, R.drawable.asset_11, R.drawable.asset_9, R.drawable.top_cart, R.drawable.top_cart};

        mBinding = ActivityQnaBinding.inflate(getLayoutInflater());

        mBinding.qnaCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QnACategoryActivity.class);
                startActivity(intent);
            }
        });

        mBinding.qnaPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.qnaPosts.setAdapter((new QnAPostsRVAdapter(getContext(), title, content, nickname, profile_img, time, view_cnt, comment_cnt, like_cnt, post_img)));

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
