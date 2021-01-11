package com.example.servicedemo.actions.impls

import android.os.Binder
import android.util.Log
import com.example.servicedemo.actions.interfaces.IBankWorkerAction

class BankWorkerActionImpl : Binder(), IBankWorkerAction {

    companion object {
        private val TAG = "BankWorkerImpl"
    }

    override fun checkUserCredit() {
        Log.d(TAG, "checkUserCredit--- > 790")
    }

    override fun freezeUserAccount() {
        Log.d(TAG, "saveMoney--- > 0")
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