package com.example.lz.android_recycler_view_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GridRecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.grid_recyclerview);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayout.VERTICAL,false));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this, R.drawable.divider_bg1));
        recyclerView.setAdapter(new GridRecyclerViewAdapter(generateData()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private List<String> generateData() {
        List<String> datas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            datas.add("" + (char) i);
        }
        return datas;
    }

    public void onInsertAtFirstItem(View view) {
        GridRecyclerViewAdapter adapter = (GridRecyclerViewAdapter) recyclerView.getAdapter();
        List<String> dataSet = adapter.getDataSet();
        dataSet.add(0, "insert one item");
        adapter.notifyItemInserted(0);
        recyclerView.scrollToPosition(0);
    }

    public void onRemoveFirstItem(View view) {
        GridRecyclerViewAdapter adapter = (GridRecyclerViewAdapter) recyclerView.getAdapter();
        List<String> dataSet = adapter.getDataSet();
        dataSet.remove(0);
        adapter.notifyItemRemoved(0);
    }
}
