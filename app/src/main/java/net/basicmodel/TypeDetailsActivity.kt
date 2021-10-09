package net.basicmodel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.layout_activity_details.*
import net.adapter.DataEntityAdapter
import net.entity.DataEntity
import net.utils.Constant
import net.utils.DataCallBack
import net.utils.RequestManager

/**
 * Copyright (C) 2021,2021/10/9, a Tencent company. All rights reserved.
 *
 * User : v_xhangxie
 *
 * Desc :
 */
class TypeDetailsActivity:AppCompatActivity(),DataCallBack {
    var type = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_details)
        initData()
    }
    private fun initData(){
        val i = intent
        type = i.getStringExtra(Constant.DETAILS).toString()
        RequestManager.get().getDetailsData(type,this)
    }

    override fun onSuccess(response: ArrayList<DataEntity>) {
        val dataAdapter = DataEntityAdapter(this,Constant.HOT,R.layout.layout_item,response)
        recyclers.layoutManager = LinearLayoutManager(this)
        recyclers.adapter = dataAdapter
        dataAdapter.setOnItemClickListener { adapter, view, position ->
            val data = adapter.data as ArrayList<DataEntity>
            val i = Intent(this, ReviewActivity::class.java)
            i.putExtra(Constant.DATA, data)
            i.putExtra(Constant.POSITION, position)
            startActivity(i)
        }
    }

    override fun onError(t: Throwable) {

    }
}