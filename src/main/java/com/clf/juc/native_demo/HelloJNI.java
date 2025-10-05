package com.clf.juc.native_demo;

/**
* ClassName: HelloJNI
* Package: com.clf.juc.native方法自定�?
* Description: 
* @Author clf
* @Create 2025/10/5 19:55 
* @Version 1.0   
*/
public class HelloJNI {
    // 声明 native 方法
    public native void sayHello();
    public native int addNumbers(int a, int b);

    // 加载本地�?
    static {
        System.loadLibrary("hello"); // 对应 hello.dll (Windows) �?libhello.so (Linux)
    }

    public static void main(String[] args) {
        HelloJNI hello = new HelloJNI();
        hello.sayHello();
        System.out.println("5 + 3 = " + hello.addNumbers(5, 3));
    }
}
