package com.example.covid_detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tablayout);
        viewPager.setAdapter(new MyOwnAdapter(this.getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }


    class MyOwnAdapter extends FragmentPagerAdapter
    {
        String data[]={"All India","Statewise"};
        public MyOwnAdapter(FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
           if (position==0)
                return new AllIndia();
           else {
               return new Statewise();
           }


        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }
}