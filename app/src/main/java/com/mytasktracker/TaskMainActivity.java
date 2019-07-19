package com.mytasktracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TaskMainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener
{
    ViewPager viewPager;
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    TextView txt;
    Button timeBtn, dateBtn;
    TextInputLayout taskNameLayout;
    EditText taskNameText;
    Task task = new Task();

    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.task_main);

        txt = findViewById(R.id.test_text);
        bottomNavigationView = findViewById(R.id.bottomnavigation_id);
        viewPager = findViewById(R.id.viewpager_id);
        taskNameText = findViewById(R.id.taskname_text);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CreateTask(), "create");
        adapter.addFragment(new TaskList(), "edit");
        viewPager.setAdapter(adapter);
    /************************************************************************************/






    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id = menuItem.getItemId();

        switch (id)
        {
            case R.id.create_id:
                viewPager.setCurrentItem(0);
                //txt.setText(getResources().getText(R.string.create));
                return true;
            case R.id.tasklist_id:
                viewPager.setCurrentItem(1);
                //txt.setText(getResources().getText(R.string.tasks));
                return true;

        }

        return false;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1)
    {

    }

    @Override
    public void onPageSelected(int i)
    {
        System.out.println("onPageSelected called");
    }

    @Override
    public void onPageScrollStateChanged(int i)
    {

    }
}
