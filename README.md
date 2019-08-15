# Summer Project

1.ndk-build、javac、dx等工具添加至环境变量

2.模块目录结构如下

CVE_XXXX_XXXX
        |----Android.mk
        |----Application.mk
        |----CVE_XXXX_XXXX.c
        |----CVE_XXXX_XXXX.java
        |----...

3.将Android SDK目录下的->platform->Android_version->android.jar 解压至 /jni/android/目录下 

4.将要编译的模块添加到modules目录下,编译成功的模块将移至source目录下

5.运行编译脚本./run.sh,编译成果在/libs/armeabi-v7a/目录下保存





