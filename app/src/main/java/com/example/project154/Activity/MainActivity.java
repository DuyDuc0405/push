package com.example.project154.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project154.Adapter.PupolarAdapter;
import com.example.project154.Domain.PopularDomain;
import com.example.project154.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;

    TextView loginName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name1");
        loginName = findViewById(R.id.name);
        loginName.setText(name);
        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-shirt black","Immerse yourself in a world of vibrant visuals and\n" +
                " immersive sound with the VisionX Pro LED TV.\n" +
                " Its cutting-edge LED technology brings every\n" +
                " scene to life with striking clarity and rich colors.\n" +
                " With seamless integration and a sleek, modern\n" +
                " design, the VisionX Pro is not just a TV, but a\n" +
                " centerpiece for your entertainment space.\n" +
                "With its sleek, modern design, the VisionX Pro is\n" +
                " not just a TV, but a centerpiece for your \n" +
                "entertainment space. The ultra-slim bezel and\n" +
                " premium finish blend seamlessly with any decor","item_1",15,4,500));
        items.add(new PopularDomain("Smart Watch","Immerse yourself in a world of vibrant visuals and\n" +
                " immersive sound with the VisionX Pro LED TV.\n" +
                " Its cutting-edge LED technology brings every\n" +
                " scene to life with striking clarity and rich colors.\n" +
                " With seamless integration and a sleek, modern\n" +
                " design, the VisionX Pro is not just a TV, but a\n" +
                " centerpiece for your entertainment space.\n" +
                "With its sleek, modern design, the VisionX Pro is\n" +
                " not just a TV, but a centerpiece for your \n" +
                "entertainment space. The ultra-slim bezel and\n" +
                " premium finish blend seamlessly with any decor","item_2",10,4.5,450));
        items.add(new PopularDomain("IPhone 14","Immerse yourself in a world of vibrant visuals and\n" +
                " immersive sound with the VisionX Pro LED TV.\n" +
                " Its cutting-edge LED technology brings every\n" +
                " scene to life with striking clarity and rich colors.\n" +
                " With seamless integration and a sleek, modern\n" +
                " design, the VisionX Pro is not just a TV, but a\n" +
                " centerpiece for your entertainment space.\n" +
                "With its sleek, modern design, the VisionX Pro is\n" +
                " not just a TV, but a centerpiece for your \n" +
                "entertainment space. The ultra-slim bezel and\n" +
                " premium finish blend seamlessly with any decor","item_3",15,4.3,800));
        items.add(new PopularDomain(" VisionX Pro LED TV","Immerse yourself in a world of vibrant visuals and\n" +
                " immersive sound with the VisionX Pro LED TV.\n" +
                " Its cutting-edge LED technology brings every\n" +
                " scene to life with striking clarity and rich colors.\n" +
                " With seamless integration and a sleek, modern\n" +
                " design, the VisionX Pro is not just a TV, but a\n" +
                " centerpiece for your entertainment space.\n" +
                "With its sleek, modern design, the VisionX Pro is\n" +
                " not just a TV, but a centerpiece for your \n" +
                "entertainment space. The ultra-slim bezel and\n" +
                " premium finish blend seamlessly with any decor","item_4",18,4.0,1500));

        recyclerViewPupolar = findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar = new PupolarAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}