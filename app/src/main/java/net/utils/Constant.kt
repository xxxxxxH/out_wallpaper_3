package net.utils

import android.Manifest

object Constant {
    val permissions = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    val title = arrayOf("hot", "all types", "setting")
    const val HOT = "hot"
    const val TYPES = "type"
    const val SETTING = "setting"
    const val DATA = "data"
    const val POSITION = "position"
    const val DETAILS = "details"
    const val BASE_URL = "https://flyspear.com/"
    const val HOT_URL = "appcar/getCategoryThumb.php?page=0&ca_pic_limit=100&ca_limit=100"
    var TYPE_DETAILS_UTL = "app{type}/getCategoryThumb.php?page=0&ca_pic_limit=100&ca_limit=100"
}