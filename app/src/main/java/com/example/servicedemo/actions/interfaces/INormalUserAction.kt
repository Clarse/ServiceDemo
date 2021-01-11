package com.example.servicedemo.actions.interfaces

interface INormalUserAction {
    //存钱
    fun saveMoney(money: Float)

    //取钱
    fun getMoney(money: Float): Float

    //贷款
    fun loanMoney(money: Float): Float

}