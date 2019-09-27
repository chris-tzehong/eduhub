package com.example.android.eduhub;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.UiAutomation;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;


public class NewSchedulerFragment extends Fragment {

    SchedulerDbHelper taskDb;

    public NewSchedulerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_scheduler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnSetTime = getView().findViewById(R.id.btnSetTime);
        Button btnSetDate = getView().findViewById(R.id.btnSetDate);
        Button btnConfirmAddTask = getView().findViewById(R.id.btnConfirmAddTask);
        TextView textViewTime = getView().findViewById(R.id.textViewTime);
        TextView textViewDate = getView().findViewById(R.id.textViewDate);
        textViewDate.setText("No date set.");
        textViewTime.setText("No time set.");
        taskDb = new SchedulerDbHelper(getActivity());
        final Task task = new Task();

        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        TextView textViewTime = getView().findViewById(R.id.textViewTime);
                        textViewTime.setText(i + ":" + i1);
                        task.setHour(i);
                        task.setMinute(i1);
                    }
                },
                        hour, minute, false);
                timePickerDialog.show();
            }
        });

        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        TextView textViewDate = getView().findViewById(R.id.textViewDate);
                        textViewDate.setText(i2 + "/" + (i1+1) + "/" + i);
                        task.setYear(i);
                        task.setMonth((i1+1));
                        task.setDay(i2);
                    }
                }, day, month, year);
                datePickerDialog.show();
            }
        });

        btnConfirmAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextTaskName = getView().findViewById(R.id.editTextTaskName);
                EditText editTextTaskDescriptionNew = getView().findViewById(R.id.editTextTaskDescriptionNew);
                task.setTaskName(editTextTaskName.getText().toString());
                task.setDescription(editTextTaskDescriptionNew.getText().toString());
                if (task.getTaskName().length() == 0 || task.getYear() == 0 || task.getHour() == 0) {
                    Toast.makeText(getActivity(), "Only description can be left blank.", Toast.LENGTH_SHORT).show();
                } else {
                    taskDb.addTask(task);
                    SchedulerFragment schedulerFragment = new SchedulerFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.frameLayoutContent, schedulerFragment, schedulerFragment.getTag()).commit();
                }

            }
        });
    }

}
