package com.smallan.mytablayoutdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by An on 2018/1/9.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<String> title;

    public TabAdapter(FragmentManager fm,List<String> title) {
        super(fm);
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        MyFragment fragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type",title.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
