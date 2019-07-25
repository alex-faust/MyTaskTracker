package com.mytasktracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder
{
    public Button priorityBtn, editBtn, deleteBtn;
    public TextView dateText, timeText, taskName;
    public CardView cardView;

    public ViewHolder(@NonNull View itemView)
    {
        super(itemView);
        cardView = itemView.findViewById(R.id.task_card_id);
        priorityBtn = itemView.findViewById(R.id.task_priorityBar_id);
        editBtn = itemView.findViewById(R.id.task_editBtn_id);
        deleteBtn = itemView.findViewById(R.id.task_deleteBtn_id);

        dateText = itemView.findViewById(R.id.task_dateText_id);
        timeText = itemView.findViewById(R.id.task_timeText_id);
        taskName = itemView.findViewById(R.id.task_taskName_id);

    }
}
