package com.zgs.view.list;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zgsHighwin on 2017/7/11 0011.
 * <p>
 * Email zgshighwin@gmail.com
 * <p>
 * Description:
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    private List<Class<? extends AppCompatActivity>> mList;

    public ListAdapter(List<Class<? extends AppCompatActivity>> list) {
        this.mList = list;

    }

    public List<Class<? extends AppCompatActivity>> getList() {
        return mList;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.tv.setText(mList.get(position).getSimpleName().split("Activity")[0]);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;

        public ListHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(android.R.id.text1);
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundColor(Color.WHITE);
            tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
