package com.zgs.view.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.zgs.view.R;

import java.util.ArrayList;
import java.util.List;


public abstract class ListActivity extends AppCompatActivity {

    private ListAdapter mListAdapter;

    protected List<Class<? extends AppCompatActivity>> mClassList;

    private RecyclerView mRecyclerView;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_activity);

    }

    /**
     * @author zgsHighwin
     * @created at 2017/7/11 0011 下午 3:54
     * @Description: setContentView()或者addContentView()方法执行完毕时就会调用该方法
     */
    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.d("ListActivity", "onContentChanged");
        mClassList = new ArrayList<>();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        setAdapter();
    }

    /**
     * @author zgsHighwin
     * @created at 2017/7/11 0011 下午 5:15
     * @Description: 设置adapter的适配器
     */
    private void setAdapter() {
        if (mListAdapter == null) {
            mListAdapter = new ListAdapter(mClassList);
        }
        addClassList();
        mListAdapter.notifyDataSetChanged();
        mListAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ListActivity.this.OnItemClickListener(view, position);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mListAdapter);
    }

    protected void OnItemClickListener(View view, int position) {
        startActivity(new Intent(this, mClassList.get(position)));
    }

    public abstract List<Class<? extends AppCompatActivity>> addClassList();

    public ListAdapter getListAdapter() {
        return mListAdapter;
    }
}
