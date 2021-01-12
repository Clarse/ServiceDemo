package com.example.servicedemo.actions.impls

import android.util.Log
import com.example.servicedemo.NormalUserAction

class NormalUserAIDLActionImpl : NormalUserAction.Stub() {

    private val TAG = "NormalUserAIDLActionImpl"

    override fun saveMoney(money: Float) {
        Log.d(TAG,"normal user save money -->" + money)
    }

    override fun getMoney(): Float {
        return 1000f
    }

}