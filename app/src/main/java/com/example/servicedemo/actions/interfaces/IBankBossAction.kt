package com.example.servicedemo.actions.interfaces

interface IBankBossAction : IBankWorkerAction {
    //修改用户账户金额
    fun modifyUserAccountMoney()
}