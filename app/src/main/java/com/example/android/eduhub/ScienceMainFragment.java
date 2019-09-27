package com.example.android.eduhub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ScienceMainFragment extends android.support.v4.app.Fragment {

    public ScienceMainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_view, container, false);
        // Inflate the layout for this fragment
        String SubjectList[] = {"Physics","Chemistry","Biology"};
        ListView simpleList = (ListView) view.findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview, R.id.textView, SubjectList);
        simpleList.setAdapter(arrayAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;

                Object obj = parent.getAdapter().getItem(position);
                String value = obj.toString();

                switch (value) {
                    case "Physics":
                        fragment = new PhysicsSubFragment();
                        replaceFragment(fragment);
                        break;

                    case "Chemistry":
                        fragment = new ChemistrySubFragment();
                        replaceFragment(fragment);
                        break;

                    case "Biology":
                        fragment = new BiologySubFragment();
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
