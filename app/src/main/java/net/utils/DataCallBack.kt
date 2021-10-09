package net.utils

import net.entity.DataEntity
import retrofit2.Response

interface DataCallBack {
    fun onSuccess(response: ArrayList<DataEntity>)
    fun onError(t: Throwable)
}