package com.example.hiwhu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class navigationFragment extends Fragment {


    public static navigationFragment newInstance(String info) {
        Bundle args = new Bundle();
        navigationFragment fragment = new navigationFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_navigation, null);
        if(getArguments().getString("info").equals("主页")){
            TabLayout tabs = (TabLayout) view.findViewById(R.id.tabs);
            tabs.addTab(tabs.newTab().setText("推荐").setTag(0));
            tabs.addTab(tabs.newTab().setText("X1类").setTag(1));
            tabs.addTab(tabs.newTab().setText("X2类").setTag(2));
            tabs.addTab(tabs.newTab().setText("X3类").setTag(3));
            tabs.addTab(tabs.newTab().setText("X4类").setTag(4));
            tabs.addTab(tabs.newTab().setText("X5类").setTag(5));

            ViewPager tab_viewPager = (ViewPager) view.findViewById(R.id.tab_viewPager);
            TabAdapter tab_adapter = new TabAdapter(getChildFragmentManager());
            for(int i=0;i<tabs.getTabCount();i++){
                tab_adapter.addFragment(new TabFragment());
            }


            tab_viewPager.setAdapter(tab_adapter);
            tabs.setupWithViewPager(tab_viewPager);
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

            return view;
        }
        else{
            TextView textView = (TextView) view.findViewById(R.id.nagative_textView);
            textView.setText(getArguments().getString("info"));
            return view;
        }

    }


}
