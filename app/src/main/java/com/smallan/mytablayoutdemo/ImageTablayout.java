package com.smallan.mytablayoutdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by An on 2018/1/9.
 */

public class ImageTablayout extends TabLayout {
    private ViewHolder holder;



    public ImageTablayout(Context context) {
        super(context);
    }

    public ImageTablayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageTablayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setTitle(@NonNull List<String> title) {
        holder = null;
        for (int i = 0; i <title.size() ; i++) {
            TabLayout.Tab tab = getTabAt(i);
            tab.setCustomView(R.layout.custome_view);
            holder = new ViewHolder(tab.getCustomView());
            if (i%2==0) {
                holder.tab_image.setVisibility(VISIBLE);
                holder.tab_text.setVisibility(GONE);
            }
            if (i==0) {
                holder.tab_text.setSelected(true);
                holder.tab_text.setTextSize(18);
            }

        }
        addOnTabSelectedListener(new MyTabListener());
    }

    public void  setSelectorLis(MyTabListener listener) {
        if (listener != null) {
            addOnTabSelectedListener(listener);
        }
    }

    class ViewHolder{
        public TextView tab_text;
        public ImageView tab_image;
        public ViewHolder(View v) {
            tab_text = v.findViewById(R.id.tab_text);
            tab_image = v.findViewById(R.id.tab_image);

        }
    }

    class MyTabListener implements OnTabSelectedListener {

        @Override
        public void onTabSelected(Tab tab) {
            holder = new ViewHolder(tab.getCustomView());
            holder.tab_text.setSelected(true);
            holder.tab_text.setTextSize(18);
        }

        @Override
        public void onTabUnselected(Tab tab) {
            holder = new ViewHolder(tab.getCustomView());
            holder.tab_text.setSelected(false);
            holder.tab_text.setTextSize(15);
        }

        @Override
        public void onTabReselected(Tab tab) {

        }
    }

}
