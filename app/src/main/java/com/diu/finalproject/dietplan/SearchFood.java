package com.diu.finalproject.dietplan;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.diu.finalproject.dietplan.FoodFragments.FoodPagerAdapter;
import com.diu.finalproject.dietplan.FoodFragments.NonVeg;
import com.diu.finalproject.dietplan.FoodFragments.Vegeterian;

public class SearchFood extends AppCompatActivity {

    private ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);

        mViewpager = findViewById(R.id.viewPager);

        FoodPagerAdapter adapter = new FoodPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Vegeterian(),"veg");
        adapter.addFragment(new NonVeg(),"non-veg");

        mViewpager.setAdapter(adapter);

        final TabLayout layout = (TabLayout)findViewById(R.id.tabLayout);
        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    layout.setTabTextColors(Color.BLACK,Color.parseColor("#008577"));
                }else if(tab.getPosition()==1){
                    layout.setTabTextColors(Color.BLACK,Color.parseColor("#ed5a5f"));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        layout.setupWithViewPager(mViewpager);

    }
}