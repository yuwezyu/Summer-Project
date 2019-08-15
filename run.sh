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

#Step3 make jar
printf "\n[*]Step3 make %s.class into jar\n" ${dir}
jar -cvfe ${dir}.jar ${dir} *.class
_exit
rm *.class
printf "%s.jar done...\n" ${dir}

#step4 make dex
printf "\n[*]Step4 make %s.jar into dex\n" ${dir}
dx --dex --output=${dir}.dex ${dir}.jar
_exit
rm *.jar
mv *.dex ${root}/libs/armeabi-v7a/
_exit
printf "\n[*]%s.dex done...\n" ${dir}
cd ${root}/modules
done

