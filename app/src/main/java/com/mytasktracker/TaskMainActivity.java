package com.mytasktracker;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class TaskMainActivity extends AppCompatActivity
{
    ViewPager viewPager;
    TabLayout tabLayout;

    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.task_main);

        viewPager = findViewById(R.id.viewpager_id);
        tabLayout = findViewById(R.id.tablayout_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CreateTask(), "create");
        adapter.addFragment(new EditTask(), "edit");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_create_black);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tasklist_black);
    }
}
