#!/bin/bash

_exit(){
	if [ $? -ne 0 ]
	then exit
	fi
}


root=`pwd` 
cd modules
_exit
printf "\n[*]Start!!!Prepareing...\n"
for dir in `ls`
do
cd ${dir}
_exit
cp -r ./* ${root}/jni
_exit
cd ${root}/jni
mv *.java ./android
_exit

#Step1 make bin
printf "\n[*]Step1 compiling %s.c\n" ${dir}
ndk-build
_exit
mv *.mp4 ${root}/libs/armeabi-v7a
rm *.c *.mk *.h
printf "%s Compiling dnoe...\n" ${dir}

#Step2 make class
printf "\n[*]Step2 compiling %s.java\n" ${dir}
cd android
javac *.java
_exit
rm *.java
printf "%s Compiling done...\n" ${dir}

#step3 make dex
printf "\n[*]Step3 make %s.jar into dex\n" ${dir}
dx --dex --output=${dir}.dex ${dir}.class
_exit
rm *.class
mv *.dex ${root}/libs/armeabi-v7a/
_exit
printf "\n[*]%s.dex done...\n" ${dir}
cd ${root}/modules
mv ${dir} ${root}/source
done

