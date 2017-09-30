package com.zgs.view.activities.refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zgs.view.R;
import com.zgs.view.adapter.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.zgs.view.configure.Constants.DATA_SIZE;

public class OneRecyclerViewInScrollViewWithRefreshActivity extends AppCompatActivity {

    private SmartRefreshLayout mSmartRefreshLayout;

    private RecyclerView mRecyclerView;
    private List<String> mList;
    private CommonAdapter mCommonAdapter;
    private ScrollView mScrollView;


    /**
     * NestScrollView和ScrollView的效果是一样的
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_recycler_view_in_scroll_view_with_refresh);
        mSmartRefreshLayout = ((SmartRefreshLayout) findViewById(R.id.smart_refresh_layout));

        mScrollView = ((ScrollView) findViewById(R.id.scroll_view));
        mRecyclerView = ((RecyclerView) findViewById(R.id.recycler_view));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCommonAdapter = new CommonAdapter(getData());
        mRecyclerView.setAdapter(mCommonAdapter);

        //设置ScrollView置顶
        mScrollView.smoothScrollTo(0, 0);
        mScrollView.setFocusable(true);
    }


    public List<String> getData() {
        mList = new ArrayList<>();
        for (int i = 0; i < DATA_SIZE; i++) {
            mList.add("text" + i);
        }
        return mList;
    }
}
