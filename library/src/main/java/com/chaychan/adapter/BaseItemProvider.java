package com.chaychan.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author ChayChan
 * @description: 条目provider的基类
 * @date 2018/3/21  10:41
 */

public abstract class BaseItemProvider<T> {

    protected Context mContext;
    protected List<T> mData;

    public abstract void convert(BaseViewHolder helper, T data, int position);

    public abstract void onClick(BaseViewHolder helper,T data,int position);

    public abstract boolean onLongClick(BaseViewHolder helper,T data,int position);
}
