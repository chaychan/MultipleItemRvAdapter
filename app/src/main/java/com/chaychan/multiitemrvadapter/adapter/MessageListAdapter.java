package com.chaychan.multiitemrvadapter.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
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

public class MessageListAdapter extends MultipleItemRvAdapter<Message,BaseViewHolder> {

    public static final int TYPE_TEXT = 0;
    public static final int TYPE_IMG = 1;

    public MessageListAdapter(@Nullable List<Message> data) {
        super(data);

        //构造函数若有传其他参数可以在调用finishInitialize()之前进行赋值，赋值给全局变量
        //这样getViewType()和registerItemProvider()方法中可以获取到传过来的值
        //getViewType()中可能因为某些业务逻辑，需要将某个值传递过来进行判断，返回对应的viewType
        //registerItemProvider()中可以将值传递给ItemProvider

        //If the constructor has other parameters, it needs to be assigned before calling finishInitialize() and assigned to the global variable
        // This getViewType () and registerItemProvider () method can get the value passed over
        // getViewType () may be due to some business logic, you need to pass a value to judge, return the corresponding viewType
        //RegisterItemProvider() can pass value to ItemProvider

        finishInitialize();
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
