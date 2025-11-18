package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image);

        ImageView imageView = findViewById(R.id.iv_main);
        //Picasso.get().load(R.drawable.wallpaper).into(imageView);
        Picasso.get().load("https://img.freepik.com/free-vector/night-ocean-landscape-full-moon-stars-shine_107791-7397.jpg")
                .placeholder(R.drawable.wallpaper)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);

    }
}