## MyTodoApp

Простой Android-проект на Kotlin + Jetpack Compose + Room, реализующий:

Список дел (Todo List)

Список покупок (Shopping List)

Динамическое добавление, удаление и обновление элементов

Начальные данные загружаются из assets/initial_data.xml

### Структура проекта
```
MyTodoApp/
├─ build.gradle.kts
├─ settings.gradle.kts
├─ gradle/
├─ gradlew
├─ gradlew.bat
├─ app/
│  ├─ build.gradle.kts
│  ├─ src/main/
│  │  ├─ AndroidManifest.xml
│  │  ├─ java/com/example/mytodo/
│  │  │  ├─ data/local/      (AppDatabase, TodoItem, TodoDao)
│  │  │  ├─ data/repository/ (TodoRepository)
│  │  │  ├─ ui/              (MainActivity)
│  │  │  │  ├─ screens/      (TodoListScreen, ShoppingListScreen)
│  │  │  ├─ viewmodel/       (TodoViewModel)
│  │  ├─ assets/              (initial_data.xml)
│  │  ├─ res/                 (values, colors, themes)
├─ scripts/
│  ├─ arch_install_sdk.sh
│  ├─ ubuntu_install_sdk.sh
│  ├─ windows_install_sdk.ps1
│  ├─ build_apk_arch.sh
│  ├─ run_emulator.sh
```
## Требования

Android Studio 2022+

JDK 17

Gradle 8+

Android SDK (см. скрипты ниже)

ADB для тестирования на устройстве/эмуляторе

### Установка SDK
Arch Linux
```
chmod +x scripts/arch_install_sdk.sh
./scripts/arch_install_sdk.sh
```
Ubuntu
```
chmod +x scripts/ubuntu_install_sdk.sh
./scripts/ubuntu_install_sdk.sh
```
Windows (PowerShell)
```
.\scripts\windows_install_sdk.ps1
```

После установки добавьте platform-tools и cmdline-tools/bin в PATH.

### Сборка и запуск
Linux / Arch / Ubuntu

Сборка APK:
```
chmod +x scripts/build_apk_arch.sh
./scripts/build_apk_arch.sh
```

Запуск на эмуляторе:
```
chmod +x scripts/run_emulator.sh
./scripts/run_emulator.sh <имя_эмулятора>
```

Установка на подключённое устройство:
```
adb install -r app/build/outputs/apk/debug/app-debug.apk
```
Windows

Сборка через Gradle Wrapper:
```
.\gradlew.bat assembleDebug

```
Установка на устройство:
```
adb install -r app\build\outputs\apk\debug\app-debug.apk
```
### Используемые технологии

Kotlin

Jetpack Compose

Room (SQLite)

MVVM архитектура (ViewModel + Repository)

Coroutine + Flow для асинхронного доступа к данным

### Особенности

Начальные данные (initial_data.xml) загружаются при первом запуске.

Список дел и список покупок можно изменять динамически:

Добавление через TextField + Button

Отметка выполнения через кнопку

Удаление через кнопку

UI полностью на Compose, легко расширяемый.
