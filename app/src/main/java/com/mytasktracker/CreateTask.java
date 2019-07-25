package com.mytasktracker;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateTask extends Fragment
{
    View viewer;
    TextView txt, dateText, timeText, priorityText, recurrenceText, notificationText;
    RadioGroup priorityGroup, recurrenceGroup, notificationGroup;
    RadioButton priorityLow, priorityMedium, priorityHigh, recurOnce, recurDaily, recurWeekly,
            notifHour, norif2Hour, notifDay;
    TextInputLayout taskNameLayout, descriptionTextLayout;
    EditText taskNameText, descriptonText;
    Context context;
    int day, month, year, hour, minutes;
    List<Task> tasks = new ArrayList<>();
    TimePickerDialog tpd;
    Calendar cal = Calendar.getInstance();
    Task task;// = new Task();
    Button createBtn, timeBtn, dateBtn;
    private DatePickerDialog.OnDateSetListener dateSetListener;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        viewer = inflater.inflate(R.layout.create_task, container, false);

        priorityGroup = viewer.findViewById(R.id.create_priorityGroup_id);
        recurrenceGroup = viewer.findViewById(R.id.create_recurrenceGroup_id);
        notificationGroup = viewer.findViewById(R.id.create_notificatonGroup_id);

        priorityLow = viewer.findViewById(R.id.create_LOW_id);
        priorityMedium = viewer.findViewById(R.id.create_MEDIUM_id);
        priorityHigh = viewer.findViewById(R.id.create_HIGH_id);
        recurOnce = viewer.findViewById(R.id.create_once_id);
        recurDaily = viewer.findViewById(R.id.create_daily_id);
        recurWeekly = viewer.findViewById(R.id.create_weekly_id);
        notifHour = viewer.findViewById(R.id.create_1HOUR_id);
        norif2Hour = viewer.findViewById(R.id.create_2HOURS_id);
        notifDay = viewer.findViewById(R.id.create_1DAY_id);

        taskNameLayout = viewer.findViewById(R.id.create_tasknamelayout_id);
        descriptionTextLayout = viewer.findViewById(R.id.create_descriptionlayout_id);

        taskNameText = viewer.findViewById(R.id.create_taskname_text);
        descriptonText = viewer.findViewById(R.id.create_description_text);

        txt = viewer.findViewById(R.id.test_text);
        dateText = viewer.findViewById(R.id.create_date_text_id);
        timeText = viewer.findViewById(R.id.create_time_text_id);
        priorityText = viewer.findViewById(R.id.create_priorityText_id);
        recurrenceText = viewer.findViewById(R.id.create_recurrenceText_id);
        notificationText = viewer.findViewById(R.id.create_notificationText_id);

        createBtn = viewer.findViewById(R.id.create_btn_id);
        dateBtn = viewer.findViewById(R.id.create_set_date_btn_id);
        timeBtn = viewer.findViewById(R.id.create_set_time_btn_id);


        /**********************************task name***********************************************/

        taskNameText.setOnFocusChangeListener((v, hasFocus) ->
        {
            if (taskNameText.getText().toString().isEmpty())
            {
                taskNameLayout.setErrorEnabled(true);
                taskNameLayout.setError("Please enter a name for the task.");
            } else
            {
                taskNameLayout.setErrorEnabled(false);
            }
        });

        taskNameText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                /*
				typing something here will show up in the run tab whatever
				character is before the one you put in.
				 */
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                /*
				typing something here will show up in the run tab whatever
				character as you type it in.
				 */
                if(taskNameText.getText().toString().isEmpty())
                {
                    taskNameLayout.setErrorEnabled(true);
                    taskNameLayout.setError("Please enter a name for the task.");
                } else
                {
                    taskNameLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        /****************************************time button***************************************/

        timeBtn.setOnClickListener( v ->
        {
            //Toast.makeText(getContext(), "time", Toast.LENGTH_SHORT).show();
            tpd = new TimePickerDialog(getContext(), (view, hourOfDay, minute) ->
                    timeText.setText(hourOfDay + ":" + minute), hour, minutes, false);
            tpd.show();

        });

        /***********************************date button********************************************/

        dateBtn.setOnClickListener(v ->
        {
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DAY_OF_MONTH);

            dateSetListener = (view, year1, month1, day1) -> {
                String date = month1 + "/"  + day1 + "/" + year1;
                dateText.setText(date);
            };

            DatePickerDialog dialog = new DatePickerDialog(getContext(),
                    AlertDialog.THEME_HOLO_LIGHT, dateSetListener,
                    year, month, day);
            dialog.show();
        });


        /***********************************description box****************************************/
        descriptonText.setOnFocusChangeListener((v, hasFocus) ->
        {
            if (taskNameText.getText().toString().isEmpty())
            {
                taskNameLayout.setErrorEnabled(true);
                taskNameLayout.setError("Please enter a name for the task.");
            } else
            {
                taskNameLayout.setErrorEnabled(false);
            }
        });



        descriptionTextLayout.setCounterEnabled(true);
        descriptionTextLayout.setCounterMaxLength(20);

        /***********************************priority***********************************************/
        priorityLow.setChecked(true);
        recurOnce.setChecked(true);
        notifHour.setChecked(true);
        /***********************************create button******************************************/

        createBtn.setOnClickListener( v ->
        {
            task = new Task();
            task.setTaskName(taskNameText.getText().toString());
            task.setTaskDescription(descriptonText.getText().toString());
            task.setDate(dateText.getText().toString());
            task.setTime(timeText.getText().toString());

            int priorityVal = priorityGroup.getCheckedRadioButtonId();
            String priorityText = "";

            switch (priorityVal)
            {
                case R.id.create_LOW_id: priorityText = "LOW";          break;
                case R.id.create_MEDIUM_id: priorityText = "MEDIUM";    break;
                case R.id.create_HIGH_id: priorityText = "HIGH";        break;
            }
            task.setPriority(priorityText);

            int recurrenceVal = recurrenceGroup.getCheckedRadioButtonId();
            String recurText = "";

            switch (recurrenceVal)
            {
                case R.id.create_once_id: recurText = "ONCE";         break;
                case R.id.create_daily_id: recurText = "DAILY";       break;
                case R.id.create_weekly_id: recurText = "WEEKLY";     break;
            }
            task.setTaskRecurrence(recurText);

            int notifVal = notificationGroup.getCheckedRadioButtonId();
            String notifText = "";

            switch (notifVal)
            {
                case R.id.create_1HOUR_id: notifText = "1_HOUR";      break;
                case R.id.create_2HOURS_id: notifText = "2_HOURS";    break;
                case R.id.create_1DAY_id: notifText = "1_DAY";        break;
            }
            task.setTaskNotification(notifText);

            TaskList fragment = new TaskList();
            Bundle bundle = new Bundle();
            //bundle.putSerializable("new task", task);
            tasks.add(task);
            bundle.putSerializable("new task", (Serializable) tasks);


            Toast.makeText(getContext(), "the size is " + tasks.size(), Toast.LENGTH_SHORT).show();


            fragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.tasklistpage_id, fragment).commit();

            taskNameText.setText("");
            descriptonText.setText("");
            timeText.setText("");
            dateText.setText("");
            priorityLow.setChecked(true);
            recurOnce.setChecked(true);
            notifHour.setChecked(true);

        });
        /***********************************more button********************************************/

        return viewer;
    }


}
