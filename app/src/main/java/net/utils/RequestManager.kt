package net.utils

import net.entity.DataEntity
import net.http.RequestService
import net.http.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestManager {
    val retrofit = RetrofitUtils().retrofit()
    val service = retrofit.create(RequestService::class.java)

    companion object {
        private var i: RequestManager? = null
            get() {
                field ?: run {
                    field = RequestManager()
                }
                return field
            }

        @Synchronized
        fun get(): RequestManager {
            return i!!
        }
    }

    fun getHotData(callBack: DataCallBack) {
        service.getHotData()
            .enqueue(object : Callback<List<DataEntity>> {
                override fun onResponse(
                    call: Call<List<DataEntity>>,
                    response: Response<List<DataEntity>>
                ) {
                    callBack.onSuccess(response.body()!! as ArrayList<DataEntity>)
                }

                override fun onFailure(call: Call<List<DataEntity>>, t: Throwable) {
                    callBack.onError(t)
                }
            })
    }

    fun getDetailsData(type: String, callBack: DataCallBack) {
        service.getTypeDetailsData(type).enqueue(object : Callback<List<DataEntity>> {
            override fun onResponse(
                call: Call<List<DataEntity>>,
                response: Response<List<DataEntity>>
            ) {
                callBack.onSuccess(response.body()!! as ArrayList<DataEntity>)
            }

            override fun onFailure(call: Call<List<DataEntity>>, t: Throwable) {
                callBack.onError(t)
            }
        })
    }
}