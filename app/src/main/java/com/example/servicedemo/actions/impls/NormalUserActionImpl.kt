package com.example.servicedemo.actions.impls

import android.os.Binder
import android.util.Log
import com.example.servicedemo.actions.interfaces.INormalUserAction

class NormalUserActionImpl : Binder(), INormalUserAction {

    companion object {
        private val TAG = "NormalUserImpl"
    }

    override fun saveMoney(money: Float) {
        Log.d(TAG, "saveMoney--- >" + money)
    }

    override fun getMoney(money: Float): Float {
        Log.d(TAG, "getMoney--- >" + money)
        return money
    }

    override fun loanMoney(money: Float): Float {
        Log.d(TAG, "loanMoney--- >" + money)
        return money
    }
}