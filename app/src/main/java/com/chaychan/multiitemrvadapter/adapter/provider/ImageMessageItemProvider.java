package com.chaychan.multiitemrvadapter.adapter.provider;

import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.chaychan.multiitemrvadapter.R;
import com.chaychan.multiitemrvadapter.adapter.MessageListAdapter;
import com.chaychan.multiitemrvadapter.model.ImageMessage;

/**
 * @author ChayChan
 * @description 图片消息条目的provider
 * @date 2018/3/21  14:43
 */
public class ImageMessageItemProvider extends BaseItemProvider<ImageMessage,BaseViewHolder> {

    @Override
    public int viewType() {
        return MessageListAdapter.TYPE_IMG;
    }

    @Override
    public int layout() {
        return R.layout.item_image_message;
    }

    @Override
    public void convert(BaseViewHolder helper, ImageMessage data, int position) {
        //处理相关业务逻辑
        ImageView iv = helper.getView(R.id.iv_img);
        Glide.with(mContext).load(data.imgUrl).into(iv);
    }

    @Override
    public void onClick(BaseViewHolder helper, ImageMessage data, int position) {
        //单击事件
        Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, ImageMessage data, int position) {
        //长按事件
        Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
        return true;
    }
}
