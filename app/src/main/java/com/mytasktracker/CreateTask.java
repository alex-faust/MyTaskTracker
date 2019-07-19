package com.mytasktracker;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateTask extends Fragment
{
    View view;
    TextView txt, dateText, timeText;
    TextInputLayout taskNameLayout, descriptionTextLayout;
    EditText taskNameText, descriptonText;
    String[] months;
    //int[] days, year;
    Task task;
    Button createBtn, timeBtn, dateBtn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.create_task, container, false);
        taskNameLayout = view.findViewById(R.id.tasknamelayout_id);
        descriptionTextLayout = view.findViewById(R.id.descriptionlayout_id);

        taskNameText = view.findViewById(R.id.taskname_text);
        descriptonText = view.findViewById(R.id.description_text);

        txt = view.findViewById(R.id.test_text);
        dateText = view.findViewById(R.id.date_text_id);
        timeText = view.findViewById(R.id.time_text_id);

        createBtn = view.findViewById(R.id.create_btn_id);
        dateBtn = view.findViewById(R.id.date_text_id);
        timeBtn = view.findViewById(R.id.time_text_id);



        createBtn.setOnClickListener( v ->
        {
            TaskList fragment = new TaskList();
            Bundle bundle = new Bundle();
            bundle.putString("taskname", taskNameText.getText().toString());
            fragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.tasklistpage_id, fragment).commit();

        });


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

        descriptionTextLayout.setCounterEnabled(true);
        descriptionTextLayout.setCounterMaxLength(100);

        /*************************************************************************************/

        dateBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getFragmentManager(), "Date Picker");
                dateText.setText(((DatePickerFragment) dialogFragment).onDateSet(););
            }


        });



        return view;
    }


}
