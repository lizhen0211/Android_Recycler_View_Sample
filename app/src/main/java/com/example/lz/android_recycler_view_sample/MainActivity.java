package com.example.lz.android_recycler_view_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSimpleRecyclerViewClick(View view) {
        Intent intent = new Intent(this, SimpleRecyclerViewActivity.class);
        startActivity(intent);
    }

    public void onSimpleCardViewClick(View view) {
        Intent intent = new Intent(this, SimpleCardViewActivity.class);
        startActivity(intent);
    }

    public void onListRecyclerViewClick(View view) {
        Intent intent = new Intent(this, ListRecyclerViewActivity.class);
        startActivity(intent);
    }

    public void onGridRecyclerViewClick(View view) {
        Intent intent = new Intent(this, GridRecyclerViewActivity.class);
        startActivity(intent);
    }

    public void onMultipleItemClick(View view) {
        Intent intent = new Intent(this, MultipleItemRecyclerViewActivity.class);
        startActivity(intent);
    }
}
