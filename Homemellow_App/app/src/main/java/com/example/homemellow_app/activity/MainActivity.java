package com.example.homemellow_app.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.homemellow_app.R;

public class MainActivity extends AppCompatActivity{
    ImageView bottom_1;
    ImageView bottom_2;
    ImageView bottom_3;
    ImageView bottom_4;
    ImageView bottom_5;

    LinearLayout navigation_1;
    LinearLayout navigation_2;
    LinearLayout navigation_3;
    LinearLayout navigation_4;
    LinearLayout navigation_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottom_1 = findViewById(R.id.bottom_1_img);
        bottom_2 = findViewById(R.id.bottom_2_img);
        bottom_3 = findViewById(R.id.bottom_3_img);
        bottom_4 = findViewById(R.id.bottom_4_img);
        bottom_5 = findViewById(R.id.bottom_5_img);

        navigation_1 = findViewById(R.id.navigation_1);
        navigation_2 = findViewById(R.id.navigation_2);
        navigation_3 = findViewById(R.id.navigation_3);
        navigation_4 = findViewById(R.id.navigation_4);
        navigation_5 = findViewById(R.id.navigation_5);

        navigation_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_1.setColorFilter(Color.parseColor("#f28705"));
                bottom_2.setColorFilter(Color.parseColor("#707070"));
                bottom_3.setColorFilter(Color.parseColor("#707070"));
                bottom_4.setColorFilter(Color.parseColor("#707070"));
                bottom_5.setColorFilter(Color.parseColor("#707070"));
                callFragment(1);
            }
        });

        navigation_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_1.setColorFilter(Color.parseColor("#707070"));
                bottom_2.setColorFilter(Color.parseColor("#f28705"));
                bottom_3.setColorFilter(Color.parseColor("#707070"));
                bottom_4.setColorFilter(Color.parseColor("#707070"));
                bottom_5.setColorFilter(Color.parseColor("#707070"));
                callFragment(2);
            }
        });

        navigation_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_1.setColorFilter(Color.parseColor("#707070"));
                bottom_2.setColorFilter(Color.parseColor("#707070"));
                bottom_3.setColorFilter(Color.parseColor("#f28705"));
                bottom_4.setColorFilter(Color.parseColor("#707070"));
                bottom_5.setColorFilter(Color.parseColor("#707070"));
                callFragment(3);
            }
        });

        navigation_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_1.setColorFilter(Color.parseColor("#707070"));
                bottom_2.setColorFilter(Color.parseColor("#707070"));
                bottom_3.setColorFilter(Color.parseColor("#707070"));
                bottom_4.setColorFilter(Color.parseColor("#f28705"));
                bottom_5.setColorFilter(Color.parseColor("#707070"));
                callFragment(4);
            }
        });

        navigation_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_1.setColorFilter(Color.parseColor("#707070"));
                bottom_2.setColorFilter(Color.parseColor("#707070"));
                bottom_3.setColorFilter(Color.parseColor("#707070"));
                bottom_4.setColorFilter(Color.parseColor("#707070"));
                bottom_5.setColorFilter(Color.parseColor("#f28705"));
                callFragment(5);
            }
        });
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
}
