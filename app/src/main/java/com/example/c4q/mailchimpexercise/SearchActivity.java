package com.example.c4q.mailchimpexercise;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.c4q.mailchimpexercise.model.FlickrModel;
import com.example.c4q.mailchimpexercise.model.Photo;
import com.example.c4q.mailchimpexercise.network.FlickrService;
import com.example.c4q.mailchimpexercise.rv.PhotoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    FlickrService flickrService = new FlickrService();
    EditText editText;
    Button submitButton;
    String text;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = findViewById(R.id.search_bar);
        submitButton = findViewById(R.id.submit_button);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editText.getText().toString();
                start();


            }
        });


    }

    public void start() {
        getPhotos();

    }

    private void getPhotos() {
        Call<FlickrModel> photoCall = flickrService.getFlickrApi().getPhotoList(text);

        photoCall.enqueue(new Callback<FlickrModel>() {
            @Override
            public void onResponse(Call<FlickrModel> call, Response<FlickrModel> response) {
// DisplayPhotosListFragment displayPhotosListFragment = new DisplayPhotosListFragment();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmenTransaction = fragmentManager.beginTransaction();
//                fragmenTransaction.replace(R.id.container, displayPhotosListFragment);
//                fragmenTransaction.commit();

                List<Photo> responsePhotoList = response.body().getPhotos().getPhoto();

                PhotoAdapter photoAdapter = new PhotoAdapter(responsePhotoList);
                recyclerView.setAdapter(photoAdapter);

            }

            @Override
            public void onFailure(Call<FlickrModel> call, Throwable t) {

                t.printStackTrace();

            }
        });
    }
}
