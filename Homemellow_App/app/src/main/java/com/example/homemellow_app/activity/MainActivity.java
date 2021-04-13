package com.example.homemellow_app.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.homemellow_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{
    ImageView bottom_1;
    ImageView bottom_2;
    ImageView bottom_3;
    ImageView bottom_4;
    ImageView bottom_5;
    int bar_stat = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottom_1 = findViewById(R.id.bottom_1_img);
        bottom_2 = findViewById(R.id.bottom_2_img);
        bottom_3 = findViewById(R.id.bottom_3_img);
        bottom_4 = findViewById(R.id.bottom_4_img);
        bottom_5 = findViewById(R.id.bottom_5_img);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_search:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.btn_bookmark:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            case R.id.btn_cart:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private void callFragment(int fragment_no) {

        // 프래그먼트 사용을 위해
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment_no) {
            case 1:
                // '프래그먼트1' 호출
                Fragment fragment1 = new FragmentPage1();
                transaction.replace(R.id.content_layout, fragment1);
                transaction.commit();
                break;

            case 2:
                // '프래그먼트2' 호출
                Fragment fragment2 = new FragmentPage2();
                transaction.replace(R.id.content_layout, fragment2);
                transaction.commit();
                break;
            case 3:
                Fragment fragment3 = new FragmentPage3();
                transaction.replace(R.id.content_layout, fragment3);
                transaction.commit();
                break;
            case 4:
                Fragment fragment4 = new FragmentPage2();
                transaction.replace(R.id.content_layout, fragment4);
                transaction.commit();
                break;
            case 5:
                Fragment fragment5 = new FragmentPage1();
                transaction.replace(R.id.content_layout, fragment5);
                transaction.commit();
                break;
        }

    }

public Boolean oonClickListern
        
    public void setBottom_1(View v){
        if(bar_stat != 1){
            bar_stat = 1;
            bottom_1.setColorFilter(Color.parseColor("#f28705"));
            bottom_2.setColorFilter(Color.parseColor("#707070"));
            bottom_3.setColorFilter(Color.parseColor("#707070"));
            bottom_4.setColorFilter(Color.parseColor("#707070"));
            bottom_5.setColorFilter(Color.parseColor("#707070"));
            callFragment(1);
        }
    }

    public void setBottom_2(View v){
        if(bar_stat != 2){
            bar_stat = 2;
            bottom_1.setColorFilter(Color.parseColor("#707070"));
            bottom_2.setColorFilter(Color.parseColor("#f28705"));
            bottom_3.setColorFilter(Color.parseColor("#707070"));
            bottom_4.setColorFilter(Color.parseColor("#707070"));
            bottom_5.setColorFilter(Color.parseColor("#707070"));
            callFragment(2);
        }
    }

    public void setBottom_3(View v){
        if(bar_stat != 3){
            bar_stat = 3;
            bottom_1.setColorFilter(Color.parseColor("#707070"));
            bottom_2.setColorFilter(Color.parseColor("#707070"));
            bottom_3.setColorFilter(Color.parseColor("#f28705"));
            bottom_4.setColorFilter(Color.parseColor("#707070"));
            bottom_5.setColorFilter(Color.parseColor("#707070"));
            callFragment(3);
        }
    }

    public void setBottom_4(View v){
        if(bar_stat != 4){
            bar_stat = 4;
            bottom_1.setColorFilter(Color.parseColor("#707070"));
            bottom_2.setColorFilter(Color.parseColor("#707070"));
            bottom_3.setColorFilter(Color.parseColor("#707070"));
            bottom_4.setColorFilter(Color.parseColor("#f28705"));
            bottom_5.setColorFilter(Color.parseColor("#707070"));
            callFragment(4);
        }
    }

    public void setBottom_5(View v){
        if(bar_stat != 5){
            bar_stat = 5;
            bottom_1.setColorFilter(Color.parseColor("#707070"));
            bottom_2.setColorFilter(Color.parseColor("#707070"));
            bottom_3.setColorFilter(Color.parseColor("#707070"));
            bottom_4.setColorFilter(Color.parseColor("#707070"));
            bottom_5.setColorFilter(Color.parseColor("#f28705"));
            callFragment(5);
        }
    }



}
