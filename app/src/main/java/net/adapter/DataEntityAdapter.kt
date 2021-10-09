package net.adapter

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.itheima.roundedimageview.RoundedImageView
import net.basicmodel.R
import net.entity.DataEntity
import net.utils.Constant
import net.utils.ScreenUtils

/**
 * Copyright (C) 2021,2021/10/9, a Tencent company. All rights reserved.
 *
 * User : v_xhangxie
 *
 * Desc :
 */
class DataEntityAdapter(
    val activity: Activity,
    val type: String,
    layoutResId: Int,
    data: ArrayList<DataEntity>?
) :
    BaseQuickAdapter<DataEntity, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, item: DataEntity) {
        when (type) {
            Constant.HOT -> {
                holder.getView<RoundedImageView>(R.id.itemBg).let {
                    it.layoutParams = it.layoutParams.apply {
                        width = ScreenUtils.getScreenSize(activity)[1]
                        height = ScreenUtils.getScreenSize(activity)[0] / 3
                    }
                    it.isOval = false
                    Glide.with(activity).load(item.img_thumb_url).into(it)
                }
                holder.setText(R.id.itemTv, item.img_title)
            }
        }
    }
}