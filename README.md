# FEM - Empowering Women, Illuminating Lives

FEM is a modern Android application designed with a beautiful bio-luminescent aesthetic, created to empower and support women through technology.

## Features

- 🎨 Modern bio-luminescent UI design with glowing cyan/teal aesthetics
- 📱 Native Android app built with Kotlin
- 🎯 Material Design 3 components
- 🌙 Dark theme optimized for OLED displays
- ⚡ Smooth animations and transitions
- 📦 Google Play Store ready

## Tech Stack

- **Language**: Kotlin
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Build System**: Gradle 8.2
- **UI Framework**: Material Design 3
- **Architecture**: Modern Android development practices

## Building the App

### Prerequisites

- Android SDK
- JDK 8 or higher
- Gradle 8.2 (included via wrapper)

### Build Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug

# Run tests
./gradlew test
```

## Project Structure

```
app/
├── src/main/
│   ├── java/com/fem/app/     # Kotlin source files
│   ├── res/                   # Resources
│   │   ├── layout/           # UI layouts
│   │   ├── values/           # Strings, colors, themes
│   │   ├── drawable/         # Vector graphics
│   │   └── mipmap/           # App icons
│   └── AndroidManifest.xml   # App configuration
├── build.gradle.kts          # App build configuration
└── proguard-rules.pro        # ProGuard rules
```

## Google Play Store Readiness

This app is configured for Google Play Store submission with:

- ✅ Proper versioning (versionCode and versionName)
- ✅ Required permissions properly declared
- ✅ Target SDK 34 (latest)
- ✅ ProGuard configuration for release builds
- ✅ Adaptive launcher icons
- ✅ Material Design 3 compliance
- ✅ Privacy and backup rules
- ✅ Proper package naming

### Before Publishing

1. Update app signing configuration in `app/build.gradle.kts`
2. Create and add keystore file
3. Add privacy policy URL
4. Update app description and screenshots
5. Test on multiple devices and Android versions
6. Run full test suite

## License

See [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
