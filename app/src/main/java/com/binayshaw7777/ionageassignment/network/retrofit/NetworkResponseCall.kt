package com.binayshaw7777.ionageassignment.network.retrofit

import com.binayshaw7777.ionageassignment.network.ApiError
import com.binayshaw7777.ionageassignment.network.NetworkResponse
import okhttp3.Request
import okio.Timeout
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkResponseCall<T>(
    private val proxy: Call<T>
) : Call<NetworkResponse<T>> {
    override fun enqueue(callback: Callback<NetworkResponse<T>>) {
        return proxy.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                val code = response.code()
                if (response.isSuccessful && body != null) {
                    callback.onResponse(
                        this@NetworkResponseCall,
                        Response.success(NetworkResponse.Success(body))
                    )
                } else {
                    val errorBody = response.errorBody()?.string()
                    val message = errorBody?.let { JSONObject(it).getString("message") }
                    callback.onResponse(
                        this@NetworkResponseCall,
                        Response.success(NetworkResponse.Error(ApiError(status = code, message = message)))
                    )
                }
            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {
                callback.onResponse(
                    this@NetworkResponseCall,
                    Response.success(NetworkResponse.Exception(throwable))
                )
            }
        })
    }

    override fun execute(): Response<NetworkResponse<T>> = throw NotImplementedError()
    override fun clone(): Call<NetworkResponse<T>> = NetworkResponseCall(proxy.clone())
    override fun request(): Request = proxy.request()
    override fun timeout(): Timeout = proxy.timeout()
    override fun isExecuted(): Boolean = proxy.isExecuted
    override fun isCanceled(): Boolean = proxy.isCanceled
    override fun cancel() = proxy.cancel()
}