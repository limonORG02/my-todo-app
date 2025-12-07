# Установка Android SDK на Windows через PowerShell

Write-Host "Скачиваем Android Command Line Tools"
$downloadUrl = "https://dl.google.com/android/repository/commandlinetools-win-9477386_latest.zip"
$destination = "$env:USERPROFILE\android-sdk\cmdline-tools.zip"
Invoke-WebRequest -Uri $downloadUrl -OutFile $destination

Write-Host "Распаковываем..."
Expand-Archive -Path $destination -DestinationPath "$env:USERPROFILE\android-sdk\cmdline-tools"
Remove-Item $destination

Write-Host "Добавьте в PATH: $env:USERPROFILE\android-sdk\cmdline-tools\bin и $env:USERPROFILE\android-sdk\platform-tools"
Write-Host "Затем установите платформы через sdkmanager, например:"
Write-Host "sdkmanager --install 'platform-tools' 'platforms;android-34' 'build-tools;34.0.0'"
