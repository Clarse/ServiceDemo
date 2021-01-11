package com.example.servicedemo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.example.servicedemo.interfaces.ICommunication
import com.example.servicedemo.services.FirstService

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.name
    private var mIsServiceBind: Boolean = false
    private lateinit var remoteBinder: ICommunication
    private lateinit var serviceName: ComponentName

    private var mServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(TAG, "onServiceConnected...")
            remoteBinder = service as ICommunication
            serviceName = name!!
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mIsServiceBind = false
            Log.d(TAG, "onServiceDisconnected...")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate...")
    }

    /*
    * 开启服务
    * */
    fun startService(view: View) {
        startService(Intent(this, FirstService::class.java))
    }

    /*
    * 停止服务
    * */
    fun stopService(view: View) {
        stopService(Intent(this, FirstService::class.java))
    }

    /*
    * 绑定服务
    * */
    fun bindService(view: View) {
        mIsServiceBind = bindService(Intent(this, FirstService::class.java), mServiceConnection, BIND_AUTO_CREATE)
    }

    /*
    * 解绑服务
    * */
    fun unBindService(view: View) {
        if (mIsServiceBind) {
            unbindService(mServiceConnection)
            mServiceConnection.onServiceDisconnected(serviceName)
            remoteBinder.javaClass
            mIsServiceBind = false
        }
    }

    /*
    * 调用Service内部方法
    * */
    fun callServiceInnerMethod(view: View) {
        if (::remoteBinder.isInitialized && mIsServiceBind) {
            remoteBinder.callServiceInnerMethod()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy...")
    }

}