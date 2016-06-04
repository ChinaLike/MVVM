package com.example.arial.mvvm.tempview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.arialyy.frame.core.AbsActivity;
import com.arialyy.frame.temp.ITempView;
import com.example.arial.mvvm.R;
import com.example.arial.mvvm.databinding.ActivityTempViewVpContentBinding;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/4/28.
 */
public class TVVPContentActivity extends AbsActivity<ActivityTempViewVpContentBinding> {
    @InjectView(R.id.vp)
    ViewPager mVp;
    @InjectView(R.id.tool_bar)
    TabLayout mTb;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setupContentViewPager(mVp);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_temp_view_vp_content;
    }

    /**
     * 初始化内容Viewpager
     */
    private void setupContentViewPager(ViewPager viewPager) {
        SimpleViewPagerAdapter adapter = new SimpleViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(TempViewFragment1.newInstance(Color.BLUE), "蓝色");
        adapter.addFrag(TempViewFragment1.newInstance(Color.YELLOW), "黄色");
        adapter.addFrag(TempViewFragment1.newInstance(Color.RED), "红色");
        adapter.addFrag(TempViewFragment1.newInstance(Color.GREEN), "绿色");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(5);
        mTb.setupWithViewPager(viewPager);
    }

    @Override
    protected void dataCallback(int result, Object data) {

    }
}
