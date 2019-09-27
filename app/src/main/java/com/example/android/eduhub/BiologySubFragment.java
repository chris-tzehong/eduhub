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

import com.google.android.youtube.player.YouTubePlayer;

public class BiologySubFragment extends Fragment {
    YouTubePlayer video;

    public BiologySubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_view, container, false);
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
                        fragment = new bio1();
                        replaceFragment(fragment);
                        break;

                    case "Chapter 2":
                        fragment = new bio2();
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
