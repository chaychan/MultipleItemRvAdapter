package com.chaychan.multiitemrvadapter.adapter;

import android.support.annotation.Nullable;

import com.chaychan.adapter.MultipleItemRvAdapter;
import com.chaychan.multiitemrvadapter.adapter.provider.ImageMessageItemProvider;
import com.chaychan.multiitemrvadapter.adapter.provider.TextMessageItemProvider;
import com.chaychan.multiitemrvadapter.model.ImageMessage;
import com.chaychan.multiitemrvadapter.model.Message;
import com.chaychan.multiitemrvadapter.model.TextMessage;

import java.util.List;

/**
 * @author ChayChan
 * @description: 消息列表的adapter
 * @date 2018/3/21  14:40
 */

public class MessageListAdapter extends MultipleItemRvAdapter<Message> {

    public static final int TYPE_TEXT = 0;
    public static final int TYPE_IMG = 1;

    public MessageListAdapter(@Nullable List<Message> data) {
        super(data);
    }

    @Override
    protected int getViewType(Message message) {
        //返回对应的viewType
        if (message instanceof TextMessage) {
            return TYPE_TEXT;
        } else if (message instanceof ImageMessage) {
            return TYPE_IMG;
        }
        return 0;
    }


    @Override
    public void registerItemProvider() {
        //注册相关的条目provider
        mProviderDelegate.registerProvider(new TextMessageItemProvider());
        mProviderDelegate.registerProvider(new ImageMessageItemProvider());
    }

}
