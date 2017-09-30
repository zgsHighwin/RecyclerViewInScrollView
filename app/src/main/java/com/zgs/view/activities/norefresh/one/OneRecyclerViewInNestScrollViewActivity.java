package com.zgs.view.activities.norefresh.one;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zgs.view.R;
import com.zgs.view.adapter.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.zgs.view.configure.Constants.DATA_SIZE;

public class OneRecyclerViewInNestScrollViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mList;
    private CommonAdapter mCommonAdapter;
    private NestedScrollView mNestScrollView;

    /**
     * 不同点在于如果使用了NestScrollView的话，RecyclerView 要设置nestedScrollingEnabled 为false ,不然有滑动冲突，header会跟随滑动
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_recycler_view_in_nest_scroll_view);
        mNestScrollView = ((NestedScrollView) findViewById(R.id.nest_scroll_view));
        mRecyclerView = ((RecyclerView) findViewById(R.id.recycler_view));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCommonAdapter = new CommonAdapter(getData());
        mRecyclerView.setAdapter(mCommonAdapter);

        //NestedScrollView
        mNestScrollView.smoothScrollTo(0, 0);
        mNestScrollView.setFocusable(true);
    }


    public List<String> getData() {
        mList = new ArrayList<>();
        for (int i = 0; i < DATA_SIZE; i++) {
            mList.add("text" + i);
        }
        return mList;
    }
}
