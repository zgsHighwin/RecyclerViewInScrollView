package com.zgs.view.activities.norefresh.multi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ScrollView;

import com.zgs.view.R;
import com.zgs.view.adapter.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.zgs.view.configure.Constants.DATA_SIZE;

public class MultiRecyclerViewInScrollViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewOne;
    private RecyclerView mRecyclerViewTwo;
    private RecyclerView mRecyclerViewThree;

    private CommonAdapter mCommonAdapter;

    private List<String> mList;
    private ScrollView mScrollView;


    /**
     * 将布局中的ScrollView 换成NestScrollView的效果是一样的
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_recycler_view_in_scroll_view);

        mRecyclerViewOne = ((RecyclerView) findViewById(R.id.recycler_view_one));
        mRecyclerViewTwo = ((RecyclerView) findViewById(R.id.recycler_view_two));
        mRecyclerViewThree = ((RecyclerView) findViewById(R.id.recycler_view_three));
        mScrollView = ((ScrollView) findViewById(R.id.scroll_view));


        mRecyclerViewOne.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewTwo.setLayoutManager(linearLayoutManager);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerViewThree.setLayoutManager(staggeredGridLayoutManager);


        mCommonAdapter = new CommonAdapter(getData());
        mRecyclerViewOne.setAdapter(mCommonAdapter);
        mRecyclerViewTwo.setAdapter(mCommonAdapter);
        mRecyclerViewThree.setAdapter(mCommonAdapter);

        //设置ScrollView置顶
        mScrollView.setFocusable(true);
        mScrollView.smoothScrollTo(0, 0);

    }


    public List<String> getData() {
        mList = new ArrayList<>();
        for (int i = 0; i < DATA_SIZE; i++) {
            mList.add("text" + i);
        }
        return mList;
    }
}
