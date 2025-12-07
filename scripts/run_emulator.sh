#!/bin/bash
# Запуск эмулятора Android (устройство должно быть создано заранее)

EMULATOR_NAME=$1

if [ -z "$EMULATOR_NAME" ]; then
  echo "Укажите имя эмулятора, например: ./run_emulator.sh Pixel_7_API_34"
  exit 1
fi

echo "Запуск эмулятора $EMULATOR_NAME..."
$ANDROID_SDK_ROOT/emulator/emulator -avd $EMULATOR_NAME
