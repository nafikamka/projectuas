package com.example.showroom;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import static com.example.showroom.MainActivity.EXTRA_DESCRIPTION;
import static com.example.showroom.MainActivity.EXTRA_NAME;
import static com.example.showroom.MainActivity.EXTRA_PRICE;
import static com.example.showroom.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_menu);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String carName = intent.getStringExtra(EXTRA_NAME);
        String carPrice = intent.getStringExtra(EXTRA_PRICE);
        String carDescription = intent.getStringExtra(EXTRA_DESCRIPTION);


        ImageView imageView = findViewById(R.id.img_menu);
        TextView textViewName = findViewById(R.id.tv_nama);
        TextView textViewPrice = findViewById(R.id.tv_harga);
        TextView textViewDescription = findViewById(R.id.tv_keterangan);

        Glide.with(this).load(imageUrl).fitCenter().centerCrop().into(imageView);
        textViewName.setText(carName);
        textViewPrice.setText("Bekas: " + carPrice);
        textViewDescription.setText(carDescription);
    }
}