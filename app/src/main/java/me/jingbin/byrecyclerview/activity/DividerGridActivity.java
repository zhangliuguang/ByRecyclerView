package me.jingbin.byrecyclerview.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import me.jingbin.byrecyclerview.R;
import me.jingbin.byrecyclerview.app.BaseActivity;
import me.jingbin.byrecyclerview.databinding.ActivityRefreshBinding;
import me.jingbin.byrecyclerview.fragment.GridFragment;
import me.jingbin.byrecyclerview.fragment.LinearFragment;
import me.jingbin.byrecyclerview.fragment.RefreshFragment;
import me.jingbin.byrecyclerview.fragment.SwipeRefreshFragment;
import me.jingbin.byrecyclerview.view.MyFragmentPagerAdapter;

/**
 * @author jingbin
 */
public class DividerGridActivity extends BaseActivity<ActivityRefreshBinding> {

    private ArrayList<String> mTitleList = new ArrayList<>(2);
    private ArrayList<Fragment> mFragments = new ArrayList<>(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        setTitle("设置分割线 (宫格/瀑布流)");

        initView();
    }

    private void initView() {
        initFragmentList();
        MyFragmentPagerAdapter myAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        binding.viewPager.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    private void initFragmentList() {
        mTitleList.clear();
        mTitleList.add("宫格");
        mTitleList.add("瀑布流");
        mFragments.add(GridFragment.newInstance("grid"));
        mFragments.add(GridFragment.newInstance("StaggeredGrid"));
    }

}
