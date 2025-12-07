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
- **Build System**: Gradle 8.0
- **UI Framework**: Material Design 3
- **Architecture**: Modern Android development practices

## Getting Started

### Quick Start Guide

For detailed build instructions, see **[BUILD_GUIDE.md](BUILD_GUIDE.md)**

### Prerequisites

- JDK 11 or higher
- Android SDK with API 34
- Gradle (included via wrapper)

### Building the App

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

> **Note**: Building requires internet access to download dependencies from Maven Central and Google Maven repositories. If you're in a restricted network environment, ensure you can access:
> - https://repo.maven.apache.org/maven2/
> - https://dl.google.com/dl/android/maven2/

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

See **[PLAY_STORE_CHECKLIST.md](PLAY_STORE_CHECKLIST.md)** for a comprehensive submission checklist.

Key steps:
1. Update app signing configuration in `app/build.gradle.kts`
2. Create and add keystore file
3. Add privacy policy URL (template provided in [PRIVACY_POLICY.md](PRIVACY_POLICY.md))
4. Update app description and screenshots
5. Test on multiple devices and Android versions
6. Run full test suite

## Documentation

- **[BUILD_GUIDE.md](BUILD_GUIDE.md)** - Comprehensive build instructions
- **[PLAY_STORE_CHECKLIST.md](PLAY_STORE_CHECKLIST.md)** - Play Store submission guide
- **[PRIVACY_POLICY.md](PRIVACY_POLICY.md)** - Privacy policy template
- **[CONTRIBUTING.md](CONTRIBUTING.md)** - Contribution guidelines

## Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

See [LICENSE](LICENSE) file for details.

## Support

If you encounter issues:
1. Check the [Issues](https://github.com/werner073-sys/FEM_Main/issues) page
2. Review the [BUILD_GUIDE.md](BUILD_GUIDE.md)
3. Create a new issue with detailed information

## Screenshots

_Screenshots will be added once the app is built and tested on physical devices._
