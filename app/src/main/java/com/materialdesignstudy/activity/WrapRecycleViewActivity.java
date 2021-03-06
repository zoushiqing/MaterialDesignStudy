package com.materialdesignstudy.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.materialdesignstudy.R;
import com.materialdesignstudy.adapter.MyWrapRecycleVlewAdapter;
import com.materialdesignstudy.weight.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class WrapRecycleViewActivity extends AppCompatActivity {

    private MyRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap_recycle);
        recyclerView = (MyRecyclerView) findViewById(R.id.id_my_recycleview);

        TextView tvHeader = new TextView(this);
        LinearLayout.LayoutParams headerParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 120);
        tvHeader.setLayoutParams(headerParam);
        tvHeader.setText("我是HeaderView");
        tvHeader.setBackgroundColor(Color.YELLOW);
        recyclerView.addHeaderView(tvHeader);

        TextView tvFooter = new TextView(this);
        LinearLayout.LayoutParams footerParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 80);
        tvFooter.setLayoutParams(footerParam);
        tvFooter.setText("我是FooterView");
        tvFooter.setBackgroundColor(Color.BLUE);
        recyclerView.addFooterView(tvFooter);

        List<String> strList=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            strList.add("item:"+i);
        }
        MyWrapRecycleVlewAdapter myAdapter=new MyWrapRecycleVlewAdapter(strList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}
