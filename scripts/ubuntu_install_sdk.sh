#!/bin/bash
# Установка Android SDK на Ubuntu

echo "Устанавливаем JDK и необходимые пакеты"
sudo apt update
sudo apt install -y openjdk-17-jdk wget unzip adb git

echo "Скачиваем Android Command Line Tools"
mkdir -p ~/android-sdk/cmdline-tools
cd ~/android-sdk/cmdline-tools
wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip -O cmdline-tools.zip
unzip cmdline-tools.zip
rm cmdline-tools.zip

echo 'export ANDROID_SDK_ROOT=$HOME/android-sdk' >> ~/.bashrc
echo 'export PATH=$PATH:$ANDROID_SDK_ROOT/cmdline-tools/bin:$ANDROID_SDK_ROOT/platform-tools' >> ~/.bashrc
source ~/.bashrc

echo "Установите платформы через sdkmanager, например:"
echo "sdkmanager --install 'platform-tools' 'platforms;android-34' 'build-tools;34.0.0'"
