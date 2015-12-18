package com.bizhi.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bizhi.xiuse.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-12-02.
 */
public class TabPager {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentActivity activity;
    private List<TabData> list = new ArrayList<TabData>();
    private TabLayout.OnTabSelectedListener listener;
    private int layout;

    public TabPager(FragmentActivity activity, TabLayout tabLayout, ViewPager viewPager, int layout) {
        this.activity = activity;
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
        this.layout = layout;
    }

    public TabPager addTab(String title, int icon, Fragment fragment) {
        list.add(new TabData(title, icon, fragment));
        return this;
    }

    public TabPager listener(TabLayout.OnTabSelectedListener listener) {
        this.listener = listener;
        return this;
    }

    public void setBadge(int position, boolean shown) {
        tabLayout.getTabAt(position).getCustomView().findViewById(R.id.badge).setVisibility(shown ? View.VISIBLE : View.INVISIBLE);
    }

    public int getCount() {
        return list.size();
    }

    public Fragment getCurrentFragment() {
        return list.get(tabLayout.getSelectedTabPosition()).fragment;
    }

    public TabPager setup() {

        viewPager.setAdapter(new FragmentPagerAdapter(activity.getSupportFragmentManager()) {
            public Fragment getItem(int position) {
                return list.get(position).fragment;
            }

            public int getCount() {
                return list.size();
            }

            public CharSequence getPageTitle(int position) {
                return list.get(position).title;
            }

        });

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(layout);
            TextView text = (TextView) tabLayout.getTabAt(i).getCustomView().findViewById(android.R.id.text1);
            text.setCompoundDrawablesWithIntrinsicBounds(0, list.get(i).icon, 0, 0);
            setBadge(i, false);
        }
        tabLayout.getTabAt(0).getCustomView().setSelected(true);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().setSelected(true);
                viewPager.setCurrentItem(tab.getPosition());
                if (listener != null) {
                    listener.onTabSelected(tab);
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                if (listener != null) {
                    listener.onTabUnselected(tab);
                }
            }

            public void onTabReselected(TabLayout.Tab tab) {
                if (listener != null) {
                    listener.onTabReselected(tab);
                }
            }
        });

        return this;
    }

    class TabData {
        String title;
        Fragment fragment;
        int icon;

        public TabData(String title, int icon, Fragment fragment) {
            this.fragment = fragment;
            this.icon = icon;
            this.title = title;
        }
    }

}
