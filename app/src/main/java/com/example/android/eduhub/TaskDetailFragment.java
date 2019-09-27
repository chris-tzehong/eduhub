package com.example.android.eduhub;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.android.eduhub.SchedulerFragment.taskPrimary;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskDetailFragment extends Fragment {

    SchedulerDbHelper taskDb;

    public TaskDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        taskDb = new SchedulerDbHelper(getActivity());
        TextView textViewTaskDetailName = getView().findViewById(R.id.textViewTaskDetailName);
        TextView textViewTaskDetailTime = getView().findViewById(R.id.textViewTaskDetailTime);
        TextView textViewTaskDetailDescription = getView().findViewById(R.id.textViewTaskDetailDescription);
        FloatingActionButton floatingActionButtonDeleteTask = getView().findViewById(R.id.floatingActionButtonDeleteTask);
        FloatingActionButton floatingActionButtonBackToScheduler = getView().findViewById(R.id.floatingActionButtonBackToScheduler);

        final Task task = taskDb.getTask(taskPrimary);
        textViewTaskDetailName.setText(task.getTaskName());
        String time = task.getYear() + "/" + task.getMonth() + "/" + task.getDay() + "  " + task.getHour() +
                ":" + task.getMinute();
        textViewTaskDetailTime.setText(time);
        textViewTaskDetailDescription.setText(task.getDescription());

        floatingActionButtonDeleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskDb.deleteTask(task);
                SchedulerFragment sf = new SchedulerFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayoutContent, sf, sf.getTag()).commit();
            }
        });

        floatingActionButtonBackToScheduler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SchedulerFragment sf = new SchedulerFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayoutContent, sf, sf.getTag()).commit();
            }
        });

    }


}
