package com.mytasktracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;


public class Task extends Fragment implements Serializable
{
    View view;
    String taskName;
    String taskDate;
    String taskTime;
    String taskDescription;
    String taskPriority; //maybe wont leave as a string
    String taskRecurrence;
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

    public String getTaskName()
    {
        return this.taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskDescription()
    {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }
    public String getDate()
    {
        return this.taskDate;
    }

    public void setDate(String taskDate)
    {
        this.taskDate = taskDate;
    }

    public String getTime()
    {
        return this.taskTime;
    }

    public void setTime(String taskTime)
    {
        this.taskTime = taskTime;
    }

    public String getPriority()
    {
        return this.taskPriority;
    }

    public void setPriority(String priorityText)
    {
        this.taskPriority = priorityText;
    }

    public String getTaskNotification()
    {
        return this.taskNotification;
    }

    public void setTaskNotification(String taskNotification)
    {
        this.taskNotification = taskNotification;
    }
    public String getTaskRecurrence()
    {
        return this.taskRecurrence;
    }

    public void setTaskRecurrence(String taskRecurrence)
    {
        this.taskRecurrence = taskRecurrence;
    }

}
