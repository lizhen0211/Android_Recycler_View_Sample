package com.example.lz.android_recycler_view_sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lz on 2018/6/5.
 */
public class MultipleItemRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT
    }

    private LayoutInflater mLayoutInflater;
    private Context mContext;

    private List<String> datas;

    public MultipleItemRecyclerViewAdapter(Context context, List<String> datas) {
        this.datas = datas;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
            return new ImageViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
        } else {
            return new TextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).mTextView.setText(datas.get(position));
        } else if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).mTextView.setText(datas.get(position));
            ((ImageViewHolder) holder).mImageView.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        TextViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text_item_tv);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        private ImageView mImageView;

        ImageViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.iv_item_img);
            mTextView = (TextView) view.findViewById(R.id.iv_item_text);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ImageViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
}
