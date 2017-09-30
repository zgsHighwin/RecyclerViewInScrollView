package com.zgs.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2017/9/27.
 */

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.Holder> {

    private List<String> mList;

    public CommonAdapter(List<String> list) {
        Log.d("CommonAdapter", "list.size():" + list.size());

        mList = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.d("CommonAdapter", "position:" + position);
        holder.tv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView tv;

        public Holder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(android.R.id.text1);
            ViewGroup.LayoutParams layoutParams = tv.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            tv.setLayoutParams(layoutParams);
        }
    }
}
