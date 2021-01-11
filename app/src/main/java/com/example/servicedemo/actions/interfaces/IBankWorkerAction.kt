package com.example.servicedemo.actions.interfaces

interface IBankWorkerAction : INormalUserAction {
    //查询用户信用
    fun checkUserCredit()

    //冻结用户账号
    fun freezeUserAccount()

}