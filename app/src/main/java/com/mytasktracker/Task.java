package com.mytasktracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

public class Task extends Fragment
{
    View view;
    String taskName;
    int[] days, year;
    Date taskDate;
    String taskDescription;
    String taskPriority; //maybe wont leave as a string
    String taskRecurrance;
    String taskNotification;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.create_task, container, false);


        return view;
    }

    public Task()
    {
        super();
    }

   /* public Task(String task)
    {
        taskName = task;
    }*/

    public String getTaskName()
    {
        return this.taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

   /* private String getMonth(int i)
    {
        return months[i];
    }
    private int getDate(int i)
    {
        return days[i];
    }*/
}
