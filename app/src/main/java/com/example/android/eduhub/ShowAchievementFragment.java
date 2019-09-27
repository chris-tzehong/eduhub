package com.example.android.eduhub;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.android.eduhub.MainActivity.loginID;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowAchievementFragment extends Fragment {

    ProgressDbHelper progressDb;


    public ShowAchievementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_achievement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textViewAchievement1 = getView().findViewById(R.id.textViewAchievement1);
        TextView textViewAchievement2 = getView().findViewById(R.id.textViewAchievement2);
        progressDb = new ProgressDbHelper(getActivity());

        Progress_Achievement progress = progressDb.getProgress(loginID);
        if (progress.getFirst_achievement() == 0) {
            textViewAchievement1.setText("You have not unlocked this achievement.");
        } else {
            textViewAchievement1.setText("Achievement unlocked. Congratulations!");
        }

        if (progress.getSecond_achievement() == 0) {
            textViewAchievement2.setText("You have not unlocked this achievement.");
        } else {
            textViewAchievement2.setText("Achievement unlocked. Congratulations!");
        }
    }
}
