package com.example.android.eduhub;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ProgressFragment extends Fragment {


    public ProgressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Progress");

        Button buttonProgressSelection = getView().findViewById(R.id.buttonProgressSelection);
        Button buttonAchievementSelection = getView().findViewById(R.id.buttonAchievementSelection);

        buttonProgressSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowProgressFragment spf = new ShowProgressFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayoutContent, spf, spf.getTag()).commit();
            }
        });

        buttonAchievementSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAchievementFragment saf = new ShowAchievementFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayoutContent, saf, saf.getTag()).commit();
            }
        });
    }
}
