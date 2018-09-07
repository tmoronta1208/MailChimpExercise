package com.example.c4q.mailchimpexercise;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.mailchimpexercise.rv.PhotoAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayPhotosListFragment extends Fragment {

    View rootView;
    RecyclerView recyclerView;
    Context context;

    public DisplayPhotosListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_display_photos_list, container, false);
//        context = rootView.getContext();
//        recyclerView = rootView.findViewById(R.id.recycler_view);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        PhotoAdapter photoAdapter = new PhotoAdapter();
        return rootView;
    }


}
