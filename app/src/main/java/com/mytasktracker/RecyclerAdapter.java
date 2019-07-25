package com.mytasktracker;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder>
{
    private List<Task> tasks;

    public RecyclerAdapter(List<Task> tasks)
    {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.task_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        Task task = tasks.get(i);
        viewHolder.taskName.setText(task.taskName);
        viewHolder.timeText.setText(task.taskTime);
        viewHolder.dateText.setText(task.taskDate);

        viewHolder.editBtn.setOnClickListener( v ->
        {
            Toast.makeText(v.getContext(), "edit button clicked", Toast.LENGTH_SHORT).show();
        });
        viewHolder.deleteBtn.setOnClickListener( v ->
        {
            Toast.makeText(v.getContext(), "delete button clicked", Toast.LENGTH_SHORT).show();
        });
        viewHolder.cardView.setOnClickListener( v ->
        {
            Toast.makeText(v.getContext(), task.getTaskDescription(), Toast.LENGTH_LONG).show();

        });

        if(task.getPriority().equals("LOW"))
        {
            viewHolder.priorityBtn.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.taskPriorityLow));
        } else if (task.getPriority().equals("MEDIUM"))
        {
            viewHolder.priorityBtn.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.taskPriorityMedium));
        } else
        {
            viewHolder.priorityBtn.setBackgroundColor(viewHolder.itemView.getResources().getColor(R.color.taskPriorityHigh));
        }
    }

    @Override
    public int getItemCount()
    {
        return tasks.size();
    }
}
