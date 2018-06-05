package com.example.lz.android_recycler_view_sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MultipleItemRecyclerViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_recycler_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.multiple_item_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerListItemDecoration(this, DividerListItemDecoration.VERTICAL_LIST));
        MultipleItemRecyclerViewAdapter adapter = new MultipleItemRecyclerViewAdapter(MultipleItemRecyclerViewActivity.this, generateData());
        recyclerView.setAdapter(adapter);
    }

    private List<String> generateData() {
        List<String> datas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            datas.add("" + (char) i);
        }
        return datas;
    }
}
