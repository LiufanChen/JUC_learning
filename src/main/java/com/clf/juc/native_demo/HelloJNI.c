#include <stdio.h>
#include <jni.h>
#include "HelloJNI.h"

// 实现 sayHello 方法
JNIEXPORT void JNICALL Java_HelloJNI_sayHello(JNIEnv *env, jobject obj) {
    printf("Hello from C!\\n");
    return;
}

// 实现 addNumbers 方法
JNIEXPORT jint JNICALL Java_HelloJNI_addNumbers(JNIEnv *env, jobject obj, jint a, jint b) {
    return a + b;
}