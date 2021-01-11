package com.example.servicedemo.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.servicedemo.actions.impls.BankBossActionImpl
import com.example.servicedemo.actions.impls.BankWorkerActionImpl
import com.example.servicedemo.actions.impls.NormalUserActionImpl

class BankService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        val action = intent?.action
        return when {
            action.equals("com.example.servicedemo.ACTION_NORMAL_USER") -> {
                NormalUserActionImpl()
            }
            action.equals("com.example.servicedemo.ACTION_BANK_WORKER") -> {
                BankWorkerActionImpl()
            }
            action.equals("com.example.servicedemo.ACTION_BANK_BOSS") -> {
                BankBossActionImpl()
            }
            else -> null
        }
    }

}