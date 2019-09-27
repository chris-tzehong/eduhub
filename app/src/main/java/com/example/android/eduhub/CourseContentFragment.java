package com.example.android.eduhub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CourseContentFragment extends Fragment implements View.OnClickListener {


    public CourseContentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        getActivity().setTitle("Course");

        CardView maths = view.findViewById(R.id.MathsCard);
        maths.setOnClickListener(this);
        CardView science = view.findViewById(R.id.ScienceCard);
        science.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;

        switch (v.getId()) {

            case R.id.MathsCard:
                fragment = new MathsMainFragment();
                replaceFragment(fragment);
                break;

            case R.id.ScienceCard:
                fragment = new ScienceMainFragment();
                replaceFragment(fragment);
                break;

            default:
                break;

        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutContent, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
