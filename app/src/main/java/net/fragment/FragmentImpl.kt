package net.fragment

import net.entity.DataEntity
import net.utils.DataCallBack
import net.utils.RequestManager

class FragmentImpl(t: String, id: Int) : BaseFragment(t, id), DataCallBack {

    override fun initData() {
        RequestManager.get().getHotData(this)
    }

    override fun initView() {

    }

    override fun onSuccess(response: List<DataEntity>) {
        
    }

    override fun onError(t: Throwable) {

    }

    private fun initHotData() {
        RequestManager.get().getHotData(this)
    }

    private fun initTypesData() {

    }

    private fun initSettingData() {

    }
}