package com.chaychan.multiitemrvadapter.adapter.provider;

import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.chaychan.multiitemrvadapter.R;
import com.chaychan.multiitemrvadapter.adapter.MessageListAdapter;
import com.chaychan.multiitemrvadapter.model.TextMessage;

/**
 * @author ChayChan
 * @description 文本消息条目的provider
 * @date 2018/3/21  14:43
 */
public class TextMessageItemProvider extends BaseItemProvider<TextMessage,BaseViewHolder> {

    @Override
    public int viewType() {
        return MessageListAdapter.TYPE_TEXT;
    }

    @Override
    public int layout() {
        return R.layout.item_text_message;
    }

    @Override
    public void convert(BaseViewHolder helper, TextMessage data, int position) {
        //处理相关业务逻辑
        helper.setText(R.id.tv_text, data.text);
    }

    @Override
    public void onClick(BaseViewHolder helper, TextMessage data, int position) {
        //单击事件
        Toast.makeText(mContext, "Click: " + data.text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, TextMessage data, int position) {
        //长按事件
        Toast.makeText(mContext, "longClick: " + data.text, Toast.LENGTH_SHORT).show();
        return true;
    }
}
