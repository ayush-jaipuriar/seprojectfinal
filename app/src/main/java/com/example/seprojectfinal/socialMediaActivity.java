package com.example.seprojectfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

public class socialMediaActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ImageView postImageView;
    private Button btnCreatePost;
    private ListView usersListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
        postImageView = findViewById(R.id.postImageView);
        btnCreatePost = findViewById(R.id.btnCreatePost);
        usersListView = findViewById(R.id.usersListView);


        mAuth = FirebaseAuth.getInstance();

        postImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.logoutItem) {
            logOut();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logOut();


    }


    private  void logOut() {
        mAuth.signOut();
        finish();

    }
}
