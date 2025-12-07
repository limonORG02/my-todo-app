#!/bin/bash
# Установка Android SDK на Arch Linux

echo "Устанавливаем Android SDK и необходимые инструменты..."
sudo pacman -S --needed android-sdk android-sdk-platform-tools android-sdk-build-tools git base-devel --noconfirm

echo "Устанавливаем переменные окружения"
echo 'export ANDROID_SDK_ROOT=/opt/android-sdk' >> ~/.bashrc
echo 'export PATH=$PATH:$ANDROID_SDK_ROOT/platform-tools:$ANDROID_SDK_ROOT/tools/bin' >> ~/.bashrc
source ~/.bashrc

echo "Готово! Проверьте команду 'adb version'"
