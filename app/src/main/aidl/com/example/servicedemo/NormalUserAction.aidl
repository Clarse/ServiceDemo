// NormalUserAction.aidl
package com.example.servicedemo;

// Declare any non-default types here with import statements

interface NormalUserAction {
    //存钱
    void saveMoney(in float money);
    //取钱
    float getMoney();
}