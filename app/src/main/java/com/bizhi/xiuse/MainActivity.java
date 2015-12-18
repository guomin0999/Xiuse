package com.bizhi.xiuse;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bizhi.view.LoadingLayout;
import com.bizhi.view.TabPager;


public class MainActivity extends AppCompatActivity {

    TabPager tabPager;
    LoadingLayout loadingLayout;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingLayout = (LoadingLayout) findViewById(R.id.loading_layout);
        loadingLayout.showLoading();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        tabPager = new TabPager(this, tabLayout, viewPager, R.layout.tab_item);
        tabPager.addTab("首页", R.drawable.tab_home, HomeFragment.newInstance("", ""));
        tabPager.addTab("推荐", R.drawable.tab_explorer, ChoiceFragment.newInstance("", ""));
        tabPager.addTab("搜索", R.drawable.tab_search, ImageListFragment.newInstance("", ""));
        tabPager.addTab("我的", R.drawable.tab_personal, ImageListFragment.newInstance("", ""));
        tabPager.addTab("本地", R.drawable.tab_manage, ImageListFragment.newInstance("", ""));
        tabPager.setup();

        loadingLayout.postDelayed(new Runnable() {
            public void run() {
                loadingLayout.showContent();
            }
        }, 10);

    }

}
