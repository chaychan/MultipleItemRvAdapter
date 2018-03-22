package com.chaychan.multiitemrvadapter.adapter.provider;

import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.chaychan.adapter.ItemProviderTag;
import com.chaychan.multiitemrvadapter.model.ImageMessage;
import com.chaychan.multiitemrvadapter.R;
import com.chaychan.multiitemrvadapter.adapter.MessageListAdapter;

/**
 * @author ChayChan
 * @description 图片消息条目的provider
 * @date 2018/3/21  14:43
 */
@ItemProviderTag(
        viewType = MessageListAdapter.TYPE_IMG,
        layout = R.layout.item_image_message
)
public class ImageMessageItemProvider extends BaseItemProvider<ImageMessage> {

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
