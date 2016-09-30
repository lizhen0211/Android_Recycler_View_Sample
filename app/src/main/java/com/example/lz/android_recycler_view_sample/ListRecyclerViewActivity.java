package com.example.lz.android_recycler_view_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
        //系统默认list分割线
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //drawable分割线
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST,R.drawable.divider_bg));

        //color分割线
        recyclerView.addItemDecoration(new DividerListItemDecoration(this, LinearLayoutManager.VERTICAL, 20, getResources().getColor(android.R.color.holo_green_light)));
        //三方分割线API https://github.com/yqritc/RecyclerView-FlexibleDivider
//        recyclerView.addItemDecoration(
//                new HorizontalDividerItemDecoration.Builder(this)
//                        //.color(Color.RED)
//                        .drawable(R.drawable.divider_bg)
//                        .size(getResources().getDimensionPixelSize(R.dimen.divider))
//                        .margin(getResources().getDimensionPixelSize(R.dimen.leftmargin),
//                                getResources().getDimensionPixelSize(R.dimen.rightmargin))
//                        .build());
    }

    private List<String> generateData() {
        List<String> datas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            datas.add("" + (char) i);
        }
        return datas;
    }

    public void onUpdateFirstItem(View view) {
        ListRecyclerViewAdapter adapter = (ListRecyclerViewAdapter) recyclerView.getAdapter();
        List<String> dataSet = adapter.getDataSet();
        dataSet.set(0, dataSet.get(0) + " is modify");
        adapter.notifyItemChanged(0);
    }

    public void onInsertAtFirstItem(View view) {
        ListRecyclerViewAdapter adapter = (ListRecyclerViewAdapter) recyclerView.getAdapter();
        List<String> dataSet = adapter.getDataSet();
        dataSet.add(0, "insert one item");
        adapter.notifyItemInserted(0);
        recyclerView.scrollToPosition(0);
    }

    public void onRemoveFirstItem(View view) {
        ListRecyclerViewAdapter adapter = (ListRecyclerViewAdapter) recyclerView.getAdapter();
        List<String> dataSet = adapter.getDataSet();
        dataSet.remove(0);
        adapter.notifyItemRemoved(0);
        recyclerView.scrollToPosition(0);
    }

    //notifyItemRangeChanged(int positionStart, int itemCount)
    //notifyItemRangeInserted(int positionStart, int itemCount)
    //notifyItemRangeRemoved(int positionStart, int itemCount)
}
