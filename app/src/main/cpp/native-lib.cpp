#include <jni.h>
#include <string>
#include <cassert>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_tombstone_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    assert(false); // You wanted a tombstone, here you go!
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}