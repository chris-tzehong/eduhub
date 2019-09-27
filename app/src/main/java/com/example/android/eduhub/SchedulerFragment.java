package com.example.android.eduhub;


import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 */
public class SchedulerFragment extends android.support.v4.app.Fragment {

    ListView listViewTaskList;
    ArrayList<Task> taskList;
    SchedulerDbHelper taskDb;
    public static String taskPrimary;


    public SchedulerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scheduler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Scheduler");

        taskDb = new SchedulerDbHelper(getActivity());
        taskList = taskDb.getAllTaskForUser();
        Iterator<Task> i = taskList.iterator();
        String[] taskNameArray = new String[taskList.size()];
        int index = 0;
        FloatingActionButton floatingActionButtonNewTask = getView().findViewById(R.id.floatingActionButtonNewTask);
        listViewTaskList = getView().findViewById(R.id.listViewTaskList);

        while(i.hasNext()){
            Task t = i.next();
            taskNameArray[index] = t.getTaskName();
            index++;
        }

        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, taskNameArray);
            listViewTaskList.setAdapter(adapter);
        } catch (RuntimeException r1) {

        }

        listViewTaskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String taskName = adapterView.getItemAtPosition(i).toString();
                taskPrimary = taskName;
                TaskDetailFragment tdf = new TaskDetailFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayoutContent, tdf, tdf.getTag()).commit();
            }
        });



        floatingActionButtonNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewSchedulerFragment nsf = new NewSchedulerFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayoutContent, nsf, nsf.getTag()).commit();

            }
        });
    }
}
