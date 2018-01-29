package com.hefu.application.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.hefu.application.R;
import com.hefu.application.adapter.ContentPagerAdapter;
import com.hefu.application.fragment.TabContentFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tooltabLayout;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    @BindView(R.id.container)
    ViewPager mContentVp;

    private ContentPagerAdapter contentAdapter;
    private List<String> tabIndicators;
    private List<Fragment> tabFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initContent();
        initTab();
    }
    private void initTab(){
        tooltabLayout.setTabMode(TabLayout.MODE_FIXED);
//        tooltabLayout.setSelectedTabIndicatorHeight(0);
        ViewCompat.setElevation(tooltabLayout, 20);
        tooltabLayout.setupWithViewPager(mContentVp);
        for (int i = 0; i < tabIndicators.size(); i++) {
            TabLayout.Tab itemTab = tooltabLayout.getTabAt(i);
            if (itemTab!=null){
                itemTab.setCustomView(R.layout.item_tab_layout_custom);
                TextView itemTv = (TextView) itemTab.getCustomView().findViewById(R.id.tv_menu_item);
                itemTv.setText(tabIndicators.get(i));
            }
        }
        tooltabLayout.getTabAt(0).getCustomView().setSelected(true);
    }
    private void initContent(){
        tabIndicators = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            tabIndicators.add("Tab" + i);
        }
        tabFragments = new ArrayList<>();
        for (String s : tabIndicators) {
            tabFragments.add(TabContentFragment.newInstance(s));
        }

        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager(),tabIndicators,tabFragments);

        mContentVp.setAdapter(contentAdapter);

    }


}
