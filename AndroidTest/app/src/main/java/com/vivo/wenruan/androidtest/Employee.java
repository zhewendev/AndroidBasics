package com.vivo.wenruan.androidtest;

public class Employee {


    public Employee(){

    }
    /*
     * 定义回调接口的成员变量
     */
    private CallBack mCallBack;
    /*
     * 声明回调接口
     */
    public interface CallBack{
        void work();
    }
    /*
     * 设置回调接口对象成员变量
     */
    public void setCallBack(CallBack callBack) {
        this.mCallBack = callBack;
    }
    /*
     * 调用回调接口对象中的方法
     */
    public void doWork() {
        mCallBack.work();
    }
}
