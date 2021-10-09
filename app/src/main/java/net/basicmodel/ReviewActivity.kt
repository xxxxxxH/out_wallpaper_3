package net.basicmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.layout_activity_review.*
import net.adapter.MyPagerAdapter
import net.entity.DataEntity
import net.utils.Constant
import net.utils.ImgUtils

/**
 * Copyright (C) 2021,2021/10/9, a Tencent company. All rights reserved.
 *
 * User : v_xhangxie
 *
 * Desc :
 */
@SuppressLint("SetTextI18n")
class ReviewActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    var data: ArrayList<DataEntity> = ArrayList()
    var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_review)
        initData()
        initViewPager()
        initView()
    }

    private fun initData() {
        val i = intent
        data = i.getSerializableExtra(Constant.DATA) as ArrayList<DataEntity>
        position = i.getIntExtra(Constant.POSITION, 0)
    }


    private fun initViewPager() {
        val adapter = MyPagerAdapter(this, data)
        viewpager.adapter = adapter
        viewpager.currentItem = position
        tv.text = "${position + 1} / ${data.size}"
        viewpager.addOnPageChangeListener(this)
    }

    private fun initView() {
        save.setOnClickListener {
            Thread(
                Runnable {
                    ImgUtils.getInstance()
                        .downloadImg(this, data[viewpager.currentItem].img_url, false)
                }
            ).start()

        }
        setWallpaper.setOnClickListener {
            Thread(
                Runnable {
                    ImgUtils.getInstance()
                        .downloadImg(this, data[viewpager.currentItem].img_url, true)
                }
            ).start()
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        tv.text = "${position + 1} / ${data.size}"
    }

    override fun onPageScrollStateChanged(state: Int) {

    }
}