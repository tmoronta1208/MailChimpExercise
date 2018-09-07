package com.example.c4q.mailchimpexercise;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c4q.mailchimpexercise.model.FlickrModel;
import com.example.c4q.mailchimpexercise.model.Photo;
import com.example.c4q.mailchimpexercise.network.FlickrService;
import com.example.c4q.mailchimpexercise.rv.PhotoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayPhotosListFragment extends Fragment {

    FlickrService flickrService;

    private View rootView;
    private RecyclerView recyclerView;
    private Context context;
    private String text;

    public DisplayPhotosListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_display_photos_list, container, false);
        context = rootView.getContext();
        flickrService = new FlickrService();

        if (getArguments() != null) {
            text = getArguments().getString("search");
            getPhotos();
        } else {
            Toast.makeText(getContext(), R.string.error_message, Toast.LENGTH_SHORT).show();
        }

        return rootView;
    }

    private void getPhotos() {
        Call<FlickrModel> photoCall = flickrService.getFlickrApi().getPhotoList(text);
        photoCall.enqueue(new Callback<FlickrModel>() {
            @Override
            public void onResponse(Call<FlickrModel> call, Response<FlickrModel> response) {

                if(response != null){
                    List<Photo> responsePhotoList = response.body().getPhotos().getPhoto();
                    setUpRecyclerView(responsePhotoList);
                } else {
                    Snackbar snackbar = Snackbar.make(
                            getView(), R.string.error_message, Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
            @Override
            public void onFailure(Call<FlickrModel> call, Throwable t) {
                Snackbar snackbar = Snackbar.make(
                        getView(), R.string.error_message, Snackbar.LENGTH_SHORT);
                snackbar.show();
                t.printStackTrace();
            }
        });
    }

    private void setUpRecyclerView(List<Photo> responseList) {
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        PhotoAdapter photoAdapter = new PhotoAdapter(responseList);
        recyclerView.setAdapter(photoAdapter);
    }

}
