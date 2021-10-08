package net.basicmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.zhouyou.http.EasyHttp
import kotlinx.android.synthetic.main.activity_main.*
import net.fragment.FragmentImpl
import net.utils.Constant
import net.utils.PermissionListener
import net.utils.PermissionsManager

class MainActivity : AppCompatActivity(), PermissionListener {
    private var views: ArrayList<Fragment> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EasyHttp.init(application)
        PermissionsManager.get().requestPermissions(this, this)
    }

    override fun granted() {
        initView()
    }

    private fun initView() {
        views.add(FragmentImpl(Constant.HOT,R.layout.layout_fragment))
        views.add(FragmentImpl(Constant.TYPES,R.layout.layout_fragment))
        views.add(FragmentImpl(Constant.SETTING,R.layout.layout_setting))
        tab.setViewPager(viewpager, Constant.title, this, views)
    }

    override fun denied() {
        finish()
    }

    override fun neverAsk() {
        finish()
    }
}