package com.mytasktracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TaskList extends Fragment
{
    View view;
    public List<Task> taskLists = new ArrayList<>();
    public List<Task> taskLists1 = new ArrayList<>();
    TextView txt;
    RecyclerView recyclerView;
    Task task = new Task();
    Task task1;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.task_list, container, false);
        txt = view.findViewById(R.id.test_text);
        recyclerView = view.findViewById(R.id.recyclerview_id);

        Bundle bundle = getArguments();
        if (bundle!= null)
        {
            //task = (Task) bundle.getSerializable("new task");
            //taskLists.add(task);
            ArrayList<Task> taskLists = (ArrayList<Task>) getArguments().getSerializable("new task");
            txt.setText("" + taskLists.size());


            /*for(int i = 0; i < taskLists.size(); i++)
            {
                task1 = new Task();
                task1.taskName = taskLists.get(i).getTaskName();

                taskLists1.add(task1);
            }
            taskLists1.add(task);*/

            //Toast.makeText(view.getContext(), "tasklist is " + taskLists.size() + "", Toast.LENGTH_SHORT).show();

            //Toast.makeText(view.getContext(), "tasklist 1 is " +  taskLists1.size() + "", Toast.LENGTH_SHORT).show();

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new RecyclerAdapter(taskLists));


        }





        return view;
    }


}
