package com.example.android.eduhub;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MathsSubFragment extends Fragment {

    public MathsSubFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_view, container, false);
        // Inflate the layout for this fragment
        String ChapterList[] = {"Chapter 1", "Chapter 2"};
        ListView simpleList = (ListView) view.findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview, R.id.textView, ChapterList);
        simpleList.setAdapter(arrayAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;

                Object obj = parent.getAdapter().getItem(position);
                String value = obj.toString();

                switch (value) {
                    case "Chapter 1":
                        fragment = new maths1();
                        replaceFragment(fragment);
                        break;

                    case "Chapter 2":
                        fragment = new maths2();
                        replaceFragment(fragment);
                        break;

                    default:
                        break;
                }
            }


        });
        return view;
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutContent, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
