package com.example.lz.android_recycler_view_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.list_recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ListRecyclerViewAdapter adapter = new ListRecyclerViewAdapter(generateData());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private List<String> generateData() {
        List<String> datas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            datas.add("" + (char) i);
        }
        return datas;
    }
}
