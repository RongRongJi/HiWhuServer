package com.example.hiwhu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hiwhu.otherActivities.AddActivity;
import com.example.hiwhu.otherActivities.LocationActivity;
import com.example.hiwhu.otherActivities.SearchActivity;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private BottomNavigationView navigation;
    private ViewPager navigation_viewPager;
    private MenuItem menuItem;
    private navigationAdapter navigation_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(this);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.search:
                        Intent intent1 = new Intent();
                        intent1.setClass(MainActivity.this, SearchActivity.class);
                        startActivity(intent1);
                        return true;
                    case R.id.add:
                        Intent intent2 = new Intent();
                        intent2.setClass(MainActivity.this, AddActivity.class);
                        startActivity(intent2);
                        return true;
                }
                return false;
            }
        });


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                navigation_viewPager.setCurrentItem(0);
                                return true;
                            case R.id.navigation_notice:
                                navigation_viewPager.setCurrentItem(1);
                                return true;
                            case R.id.navigation_user:
                                navigation_viewPager.setCurrentItem(2);
                                return true;
                        }
                        return false;
                    }
                });

        navigation_viewPager = (ViewPager) findViewById(R.id.navigation_viewPager);
        navigation_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        navigation_adapter = new navigationAdapter(getSupportFragmentManager());

        navigation_adapter.addFragment(navigationFragment.newInstance("主页"));
        navigation_adapter.addFragment(navigationFragment.newInstance("消息"));
        navigation_adapter.addFragment(navigationFragment.newInstance("我的"));
        navigation_viewPager.setAdapter(navigation_adapter);

    }

    @Override
    public void onClick(View view) {
        Intent intent3 = new Intent();
        intent3.setClass(MainActivity.this,LocationActivity.class);
        startActivity(intent3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 绑定toolbar跟menu
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

}
