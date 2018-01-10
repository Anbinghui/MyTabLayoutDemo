package com.smallan.mytablayoutdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by An on 2018/1/9.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<String> title;
    private Context context;
    public TabAdapter(FragmentManager fm,List<String> title,Context context) {
        super(fm);
        this.title = title;
        this.context = context;
    }


    /**自定义布局,并绑定数据
     * @param position
     * @return
     */
    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custome_view,null);
        TextView tv = view.findViewById(R.id.tab_text);
        ImageView iv  = view.findViewById(R.id.tab_image);
        if (position%2==0) {
            iv.setVisibility(View.VISIBLE);
            tv.setVisibility(View.GONE);
        }else {
            tv.setText(title.get(position));
        }

        return view;
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
