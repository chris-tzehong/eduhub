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
public class ShowProgressFragment extends Fragment {

    ProgressDbHelper progressDb;

    public ShowProgressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_progress, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textViewMaths1 = getView().findViewById(R.id.textViewMaths1);
        TextView textViewMaths2 = getView().findViewById(R.id.textViewMaths2);
        TextView textViewAddMaths1 = getView().findViewById(R.id.textViewAddMaths1);
        TextView textViewAddMaths2 = getView().findViewById(R.id.textViewAddMaths2);
        TextView textViewPhysics1 = getView().findViewById(R.id.textViewPhysics1);
        TextView textViewPhysics2 = getView().findViewById(R.id.textViewPhysics2);
        TextView textViewChemistry1 = getView().findViewById(R.id.textViewChemistry1);
        TextView textViewChemistry2 = getView().findViewById(R.id.textViewChemistry2);
        TextView textViewBiology1 = getView().findViewById(R.id.textViewBiology1);
        TextView textViewBiology2 = getView().findViewById(R.id.textViewBiology2);
        progressDb = new ProgressDbHelper(getActivity());

        Progress_Achievement progress = progressDb.getProgress(loginID);
        textViewMaths1.setText("Mathematics Chapter 1: " + progress.getMaths1());
        textViewMaths2.setText("Mathematics Chapter 2: " + progress.getMaths2());
        textViewAddMaths1.setText("Additional Mathematics Chapter 1: " + progress.getAddmaths1());
        textViewAddMaths2.setText("Additional Mathematics Chapter 2: " + progress.getAddmaths2());
        textViewPhysics1.setText("Physics Chapter 1: " + progress.getPhysics1());
        textViewPhysics2.setText("Physics Chapter 2: " + progress.getPhysics2());
        textViewChemistry1.setText("Chemistry Chapter 1: " + progress.getChemistry1());
        textViewChemistry2.setText("Chemistry Chapter 2: " + progress.getChemistry2());
        textViewBiology1.setText("Biology Chapter 1: " + progress.getBiology1());
        textViewBiology2.setText("Biology Chapter 2: " + progress.getBiology2());


    }
}
