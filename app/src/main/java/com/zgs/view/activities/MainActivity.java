package com.zgs.view.activities;

import android.support.v7.app.AppCompatActivity;

import com.zgs.view.activities.norefresh.multi.MultiRecyclerViewInScrollViewActivity;
import com.zgs.view.activities.norefresh.one.OneRecyclerViewInNestScrollViewActivity;
import com.zgs.view.activities.norefresh.one.OneRecyclerViewInScrollViewActivity;
import com.zgs.view.activities.refresh.MultiRecyclerViewInScrollViewWithRefreshActivity;
import com.zgs.view.activities.refresh.OneRecyclerViewInScrollViewWithRefreshActivity;
import com.zgs.view.list.ListActivity;

import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    public List<Class<? extends AppCompatActivity>> addClassList() {
        mClassList.add(OneRecyclerViewInScrollViewActivity.class);
        mClassList.add(OneRecyclerViewInNestScrollViewActivity.class);
        mClassList.add(MultiRecyclerViewInScrollViewActivity.class);
        mClassList.add(OneRecyclerViewInScrollViewWithRefreshActivity.class);
        mClassList.add(MultiRecyclerViewInScrollViewWithRefreshActivity.class);
        return mClassList;
    }
}
