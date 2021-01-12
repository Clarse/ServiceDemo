package com.example.servicedemo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import com.example.servicedemo.actions.impls.NormalUserActionImpl
import com.example.servicedemo.actions.interfaces.INormalUserAction

class NormalUserActivity : AppCompatActivity() {

    private lateinit var mNormalUserConnection: NormalUserConnection

    companion object {
        private val TAG = "NormalUserActivity"
        private var mIsBind = false
        private lateinit var serviceName: ComponentName
        private lateinit var mNormalUserAction: NormalUserAction
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_user)
        doBindService()
    }

    //绑定服务
    private fun doBindService() {
        Log.d(TAG, "doBindService..")
        val intent = Intent()
        intent.action = "com.example.servicedemo.ACTION_NORMAL_USER"
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        intent.setPackage(this.packageName)
        mNormalUserConnection = NormalUserConnection()
        mIsBind = bindService(intent, mNormalUserConnection, BIND_AUTO_CREATE)
    }

    class NormalUserConnection : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            serviceName = name!!
            mNormalUserAction = NormalUserAction.Stub.asInterface(service)
            Log.d(TAG, "onServiceConnected.." + name)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected.." + name)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mNormalUserConnection.isInitialized && mIsBind) {
            unbindService(mNormalUserConnection)
            mNormalUserConnection.onServiceDisconnected(serviceName)
            mIsBind = false
            Log.d(TAG, "unbind Service..")
        }
    }

    fun saveMoneyClick(view: View) {
        Log.d(TAG, "saveMoneyClick..")
        mNormalUserAction.saveMoney(100f)
    }

    fun getMoneyClick(view: View) {
        Log.d(TAG, "getMoneyClick..")
        val money = mNormalUserAction.money
        Log.d(TAG, "get money is -->" + money)
    }

    fun loanMoneyClick(view: View) {
        Log.d(TAG, "loanMoneyClick..")
    }

}