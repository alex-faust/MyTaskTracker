package com.mytasktracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TaskList extends Fragment
{
    View view;
    List<Fragment> taskLists = new ArrayList<>();
    ListView listView;
    TextView txt;
    final String[] tasks = new String[]{"one", "two", "three"};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.edit_task, container, false);
        listView = view.findViewById(R.id.listOfTask_id);
        txt = view.findViewById(R.id.test_text);

        Bundle bundle = getArguments();
        if (bundle!= null)
        {
            String value = getArguments().getString("taskname");
            txt.setText(value);
        }

        ArrayAdapter<String> taskAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(taskAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            txt.setText(tasks[position]);
            Toast.makeText(view.getContext(), tasks[position], Toast.LENGTH_SHORT).show();
        });



        return view;
    }
    public void setText(String str)
    {
        str = txt.toString();
    }

}
