package net.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_item_vp.*
import net.basicmodel.R
import net.entity.DataEntity

/**
 * Copyright (C) 2021,2021/10/9, a Tencent company. All rights reserved.
 *
 * User : v_xhangxie
 *
 * Desc :
 */
class MyPagerAdapter(val context: Context, val data: ArrayList<DataEntity>): PagerAdapter(){
    override fun getCount(): Int {
       return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(context).inflate(R.layout.layout_item_vp, container, false) as View
        val img = view.findViewById<ImageView>(R.id.itemImg)
        Glide.with(context).load(data[position].img_thumb_url).into(img)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as LinearLayout)
    }
}