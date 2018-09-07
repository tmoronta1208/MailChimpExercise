package com.example.c4q.mailchimpexercise;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    private EditText editText;
    private Button submitButton;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = findViewById(R.id.search_bar);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editText.getText().toString().toLowerCase();

                if (text == null || text.isEmpty()) {
                    Toast.makeText(getBaseContext(), R.string.search_criteria_error, Toast.LENGTH_SHORT).show();
                } else {
                    displayFragment();
                }
            }
        });
    }

    public void displayFragment() {
        DisplayPhotosListFragment displayPhotosListFragment = new DisplayPhotosListFragment();
        Bundle args = new Bundle();
        args.putString("search", text);
        displayPhotosListFragment.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmenTransaction = fragmentManager.beginTransaction();
        fragmenTransaction.replace(R.id.container, displayPhotosListFragment);
        fragmenTransaction.commit();
    }

}
