package com.example.servicedemo.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.example.servicedemo.actions.interfaces.ICommunication

class FirstService : Service() {
    private val TAG = FirstService::class.java.name

    private inner class InnerBinder : Binder(), ICommunication {
        override fun callServiceInnerMethod() {
            sayHello()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "onBind...")
        return InnerBinder()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind...")
        return false
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate...")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand...")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy...")
    }

    private fun sayHello() {
        Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show()
    }

}