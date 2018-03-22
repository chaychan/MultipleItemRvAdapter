package com.chaychan.multiitemrvadapter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chaychan.multiitemrvadapter.model.ImageMessage;
import com.chaychan.multiitemrvadapter.model.Message;
import com.chaychan.multiitemrvadapter.R;
import com.chaychan.multiitemrvadapter.model.TextMessage;
import com.chaychan.multiitemrvadapter.adapter.MessageListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvMessages;
    private List<Message> mMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvMessages = findViewById(R.id.rv_message);

        mRvMessages.setHasFixedSize(true);
        mRvMessages.setLayoutManager(new LinearLayoutManager(this));

        String imgUrl1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521627479112&di=7b109af49f8c1c193c3173306cf58680&imgtype=0&src=http%3A%2F%2Fimg.xgo-img.com.cn%2Fpics%2F1538%2F1537620.jpg";
        String imgUrl2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1521617426&di=d6537bb0ef71984e4a1d14e4b18ba169&src=http://img1d.xgo-img.com.cn/pics/789/788784.jpg";

        mMessages.add(new TextMessage("你好呀，哈哈哈哈，呜啦啦啦啦"));
        mMessages.add(new ImageMessage(imgUrl1));
        mMessages.add(new TextMessage("嗯嗯，今天天气真不错！"));
        mMessages.add(new ImageMessage(imgUrl2));

        mRvMessages.setAdapter(new MessageListAdapter(mMessages));
    }
}
