#!/bin/bash
# Сборка APK на Arch/Linux

echo "Сборка debug APK..."
./gradlew assembleDebug

echo "Готово! APK находится в app/build/outputs/apk/debug/"
