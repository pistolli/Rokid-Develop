package com.hefu.application.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class ContentPagerAdapter extends FragmentPagerAdapter {
    List<String> tabIndicators;
    List<Fragment> tabFragments;
        public ContentPagerAdapter(FragmentManager fm, List<String> tabIndicators, List<Fragment> tabFragments) {
            super(fm);
            this.tabIndicators=tabIndicators;
            this.tabFragments=tabFragments;


        }


    @Override
    public Fragment getItem(int position) {
        return tabFragments.get(position);
    }

    @Override
    public int getCount() {
        return tabIndicators.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabIndicators.get(position);
    }
}