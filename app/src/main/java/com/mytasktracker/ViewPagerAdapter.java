package com.mytasktracker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter
{
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int i)
    {
        return fragmentList.get(i);
    }

    @Override
    public int getCount()
    {
        return fragmentTitleList.size();
    }

    public void addFragment(Fragment frag, String str)
    {
        fragmentList.add(frag);
        fragmentTitleList.add(str);
    }

    public CharSequence getPageTitle(int position)
    {
        return fragmentTitleList.get(position);
    }
}
