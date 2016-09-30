package com.example.lz.android_recycler_view_sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lz on 2016/9/29.
 */
public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.ViewHolder> {

    private List<String> dataSet;

    private List<Integer> mHeights;

    public GridRecyclerViewAdapter(List<String> myDataset) {
        dataSet = myDataset;
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < dataSet.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_recyclerview_item, parent, false);
        ViewHolder vh = new ViewHolder(root);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(dataSet.get(position));
        ViewGroup.LayoutParams lp = holder.text.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.text.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.grid_item_text);
        }
    }

    public List<String> getDataSet() {
        return dataSet;
    }
}
