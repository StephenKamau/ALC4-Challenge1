package com.example.alc4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private CircleImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(R.string.toolbar_title_c);
        profileImageView = findViewById(R.id.img_profile);
        Glide.with(this).load(R.drawable.profile_image).into(profileImageView);
    }
}
