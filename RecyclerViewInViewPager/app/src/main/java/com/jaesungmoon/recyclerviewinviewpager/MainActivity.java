package com.jaesungmoon.recyclerviewinviewpager;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.jaesungmoon.recyclerviewinviewpager.fragments.CrimeFragment;
import com.jaesungmoon.recyclerviewinviewpager.fragments.DocumentaryFragment;
import com.jaesungmoon.recyclerviewinviewpager.fragments.DramaFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener((view) -> {
//            Snackbar.make(view, "Replace with your own action ")
//        });


        ViewPager vp = findViewById(R.id.veiwPager);
        addPages(vp);

        TabLayout tabLayout = findViewById(R.id.mTab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(listener(vp));

    }
    private void addPages(ViewPager viewPager) {
        MyFragPagerAdapter adapter = new MyFragPagerAdapter(getSupportFragmentManager());
        adapter.addPage(new DramaFragment());
        adapter.addPage(new DocumentaryFragment());
        adapter.addPage(new CrimeFragment());
        viewPager.setAdapter(adapter);
    }

    private TabLayout.OnTabSelectedListener listener(final ViewPager pager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }
}
