# Android RASP SDK

Lightweight Runtime Application Self-Protection SDK for Android.

## Features
- Debugger detection
- Root detection
- Emulator detection
- Hook / Frida detection
- App tampering detection

## Usage
```kotlin
Rasp.check(this, RaspConfig(killAppOnThreat = true))
```

## Disclaimer
Defensive use only.
