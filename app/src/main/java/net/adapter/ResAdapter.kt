package net.adapter

import android.app.Activity
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.itheima.roundedimageview.RoundedImageView
import net.basicmodel.R
import net.entity.ResourceEntity
import net.utils.ScreenUtils

/**
 * Copyright (C) 2021,2021/10/9, a Tencent company. All rights reserved.
 *
 * User : v_xhangxie
 *
 * Desc :
 */
class ResAdapter(val activity: Activity, layoutResId: Int, data: ArrayList<ResourceEntity>?) :
    BaseQuickAdapter<ResourceEntity, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, item: ResourceEntity) {
        holder.getView<RoundedImageView>(R.id.itemBg).let {
            it.layoutParams = it.layoutParams.apply {
                width = (ScreenUtils.getScreenSize(activity)[1] / 3)
                height = (ScreenUtils.getScreenSize(activity)[1] / 3)
            }
            it.isOval = true
            Glide.with(activity).load(item.id).into(it)
        }
        holder.setText(R.id.itemTv, item.name)
    }
}