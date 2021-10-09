package net.fragment

import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import kotlinx.android.synthetic.main.layout_fragment.*
import kotlinx.android.synthetic.main.layout_setting.*
import net.adapter.DataEntityAdapter
import net.adapter.ResAdapter
import net.basicmodel.R
import net.basicmodel.ReviewActivity
import net.basicmodel.TypeDetailsActivity
import net.entity.DataEntity
import net.entity.ResourceEntity
import net.utils.*


class FragmentImpl(t: String, id: Int) : BaseFragment(t, id), DataCallBack {

    override fun initData() {
        when (type) {
            Constant.HOT -> initHotData()
            Constant.TYPES -> initTypesData()
            Constant.SETTING -> initSettingData()
        }
    }

    override fun initView() {

    }

    override fun onSuccess(response: ArrayList<DataEntity>) {
        when (type) {
            "hot" -> {
                val dataAdapter =
                    DataEntityAdapter(requireActivity(), type, R.layout.layout_item, response)
                recycler.layoutManager = LinearLayoutManager(activity)
                recycler.adapter = dataAdapter
                recycler.addItemDecoration(
                    HorizontalDividerItemDecoration.Builder(activity).build()
                )
                dataAdapter.setOnItemClickListener { adapter, view, position ->
                    val data = adapter.data as ArrayList<DataEntity>
                    val i = Intent(activity, ReviewActivity::class.java)
                    i.putExtra(Constant.DATA, data)
                    i.putExtra(Constant.POSITION, position)
                    activity?.startActivity(i)
                }
            }
        }
    }

    override fun onError(t: Throwable) {

    }

    private fun initHotData() {
        RequestManager.get().getHotData(this)
    }

    private fun initTypesData() {
        val data = activity?.let {
            ResourceManager.get().getResourceByFolder(it, R.mipmap::class.java, "mipmap", "ic")
        }
        val resAdapter = activity?.let { ResAdapter(it, R.layout.layout_item, data) }
        recycler.layoutManager = GridLayoutManager(activity, 3)
        recycler.adapter = resAdapter
        resAdapter?.setOnItemClickListener { adapter, view, position ->
            val entity = adapter.data[position] as ResourceEntity
            val type = entity.name.substring(0, entity.name.length - 3)
            val i = Intent(activity, TypeDetailsActivity::class.java)
            i.putExtra(Constant.DETAILS, type)
            activity?.startActivity(i)
        }
    }

    private fun initSettingData() {
        eva.setOnClickListener {
            EvaManager().Market(requireActivity(), EvaManager().getPkgName(requireContext()))
        }
    }
}