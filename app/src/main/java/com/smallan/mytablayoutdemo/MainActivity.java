package com.smallan.mytablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewHolder holder;
    private List<String> title = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        setTabView();

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.tvName.setSelected(true);
                holder.tvName.setTextSize(18);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.tvName.setSelected(false);
                holder.tvName.setTextSize(15);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setTabView() {
        holder = null;
        for (int i = 0; i <title.size() ; i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(R.layout.custome_view);
                holder = new ViewHolder(tab.getCustomView());
            if(i%2==0) {
                holder.ivTab.setVisibility(View.VISIBLE);
                holder.tvName.setVisibility(View.GONE);
            }
            holder.tvName.setText(title.get(i));
            if(i==0) {
                holder.tvName.setSelected(true);
                holder.tvName.setTextSize(20);
            }

        }
    }

    private void initData() {
        for (int i = 0; i <10 ; i++) {
            title.add("标题"+i);
        }
        TabAdapter mAdapter = new TabAdapter(getSupportFragmentManager(),title);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.pager);
    }

    class ViewHolder{
        TextView tvName;
        ImageView ivTab;
        public ViewHolder(View tabview) {
            tvName = tabview.findViewById(R.id.tab_text);
            ivTab = tabview.findViewById(R.id.tab_image);
        }
    }
}
