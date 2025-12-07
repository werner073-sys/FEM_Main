# Building FEM Android App

## Quick Start

This guide will help you build the FEM Android app in your local development environment.

## Prerequisites

### Required Software
1. **Java Development Kit (JDK)**
   - JDK 11 or higher (JDK 17 recommended)
   - Download from: https://adoptium.net/

2. **Android Studio** (Recommended)
   - Latest version
   - Download from: https://developer.android.com/studio
   - Includes Android SDK and build tools

   OR

3. **Android SDK Command Line Tools**
   - Download from: https://developer.android.com/studio#command-tools
   - Set `ANDROID_HOME` environment variable

### Android SDK Requirements
- **Build Tools**: 34.0.0 or higher
- **Platform**: Android 14 (API 34)
- **SDK Tools**: Latest version

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/werner073-sys/FEM_Main.git
cd FEM_Main
```

### 2. Set Up Android SDK
If not using Android Studio, set the environment variable:

**Linux/macOS:**
```bash
export ANDROID_HOME=/path/to/android/sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

**Windows:**
```cmd
set ANDROID_HOME=C:\path\to\android\sdk
set PATH=%PATH%;%ANDROID_HOME%\tools;%ANDROID_HOME%\platform-tools
```

### 3. Install Required SDK Components
```bash
sdkmanager "platforms;android-34"
sdkmanager "build-tools;34.0.0"
sdkmanager "platform-tools"
```

## Building the App

### Debug Build
Build a debug APK for testing:
```bash
./gradlew assembleDebug
```

Output: `app/build/outputs/apk/debug/app-debug.apk`

### Release Build
Build a release APK for distribution:
```bash
./gradlew assembleRelease
```

Output: `app/build/outputs/apk/release/app-release-unsigned.apk`

### Android App Bundle (Recommended for Play Store)
Build an AAB file for Play Store submission:
```bash
./gradlew bundleRelease
```

Output: `app/build/outputs/bundle/release/app-release.aab`

## App Signing

For release builds, you need to sign the app. Create a signing configuration:

### 1. Generate a Keystore
```bash
keytool -genkey -v -keystore fem-release-key.keystore -alias fem -keyalg RSA -keysize 2048 -validity 10000
```

**Important**: Keep your keystore file and passwords secure!

### 2. Configure Signing in app/build.gradle.kts

Add the following to your `app/build.gradle.kts`:

```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("path/to/fem-release-key.keystore")
            storePassword = "your-store-password"
            keyAlias = "fem"
            keyPassword = "your-key-password"
        }
    }
    
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            // ... other configs
        }
    }
}
```

**Better Practice**: Use environment variables or gradle.properties:

```kotlin
// In app/build.gradle.kts
signingConfigs {
    create("release") {
        storeFile = file(project.findProperty("FEM_KEYSTORE_FILE") as String)
        storePassword = project.findProperty("FEM_KEYSTORE_PASSWORD") as String
        keyAlias = project.findProperty("FEM_KEY_ALIAS") as String
        keyPassword = project.findProperty("FEM_KEY_PASSWORD") as String
    }
}
```

Then create `local.properties` (not committed to git):
```properties
FEM_KEYSTORE_FILE=/path/to/keystore
FEM_KEYSTORE_PASSWORD=your-store-password
FEM_KEY_ALIAS=fem
FEM_KEY_PASSWORD=your-key-password
```

## Running the App

### On a Connected Device
```bash
./gradlew installDebug
adb shell am start -n com.fem.app/.MainActivity
```

### Using Android Studio
1. Open the project in Android Studio
2. Select a device or emulator
3. Click the "Run" button (▶)

## Testing

### Run Unit Tests
```bash
./gradlew test
```

### Run Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

### Lint Check
```bash
./gradlew lint
```

## Common Issues and Solutions

### Issue: Gradle build fails with dependency errors
**Solution**: Ensure you have an internet connection and can access:
- https://repo.maven.apache.org/maven2/
- https://dl.google.com/dl/android/maven2/

#### Firewall and Proxy Configuration

If you're behind a corporate firewall or proxy, you need to configure Gradle to use it.

**Option 1: Configure in gradle.properties**

Edit or create `gradle.properties` file in your project root or `~/.gradle/gradle.properties`:

```properties
# Proxy configuration
systemProp.http.proxyHost=proxy.company.com
systemProp.http.proxyPort=8080
systemProp.https.proxyHost=proxy.company.com
systemProp.https.proxyPort=8080

# If proxy requires authentication
systemProp.http.proxyUser=username
systemProp.http.proxyPassword=password
systemProp.https.proxyUser=username
systemProp.https.proxyPassword=password

# Non-proxy hosts (optional)
systemProp.http.nonProxyHosts=*.nonproxyrepos.com|localhost
```

**Option 2: Use environment variables**

```bash
# Linux/macOS
export GRADLE_OPTS="-Dhttp.proxyHost=proxy.company.com -Dhttp.proxyPort=8080 -Dhttps.proxyHost=proxy.company.com -Dhttps.proxyPort=8080"

# Windows (PowerShell)
$env:GRADLE_OPTS="-Dhttp.proxyHost=proxy.company.com -Dhttp.proxyPort=8080 -Dhttps.proxyHost=proxy.company.com -Dhttps.proxyPort=8080"
```

**Option 3: Configure in Android Studio**

1. Open **File → Settings → Appearance & Behavior → System Settings → HTTP Proxy**
2. Select "Manual proxy configuration"
3. Enter your proxy details
4. Click "Check connection" to verify

#### Firewall Rules Required

If you manage your own firewall, allow outbound HTTPS connections to:

**Required domains:**
- `dl.google.com` - Google Maven repository (Android Gradle Plugin, Google libraries)
- `repo.maven.apache.org` - Maven Central (Kotlin, AndroidX, third-party libraries)
- `services.gradle.org` - Gradle distributions
- `repo1.maven.org` - Maven Central mirror
- `jcenter.bintray.com` - JCenter (deprecated but may be needed for older dependencies)
- `plugins.gradle.org` - Gradle Plugin Portal

**Ports:**
- Port 443 (HTTPS)
- Port 80 (HTTP, if needed)

**Test connectivity:**
```bash
# Test Google Maven
curl -I https://dl.google.com/dl/android/maven2/

# Test Maven Central
curl -I https://repo.maven.apache.org/maven2/

# Test Gradle services
curl -I https://services.gradle.org/distributions/
```

#### Using a Mirror Repository

If you cannot access external repositories, set up a local Maven mirror (e.g., Nexus, Artifactory):

```kotlin
// In build.gradle.kts
buildscript {
    repositories {
        maven {
            url = uri("https://your-company-mirror.com/maven-public/")
            // Add credentials if needed
            credentials {
                username = project.findProperty("repoUser") as String?
                password = project.findProperty("repoPassword") as String?
            }
        }
    }
}

allprojects {
    repositories {
        maven {
            url = uri("https://your-company-mirror.com/maven-public/")
        }
    }
}
```

### Issue: Android SDK not found
**Solution**: 
1. Install Android Studio or Android Command Line Tools
2. Set `ANDROID_HOME` environment variable
3. Verify with: `echo $ANDROID_HOME` (Linux/Mac) or `echo %ANDROID_HOME%` (Windows)

### Issue: Build tools version not found
**Solution**: Install the required build tools version:
```bash
sdkmanager "build-tools;34.0.0"
```

### Issue: Out of memory during build
**Solution**: Increase Gradle memory in `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx4096m -XX:MaxMetaspaceSize=512m
```

## Build Optimization

### Faster Builds
Add to `gradle.properties`:
```properties
org.gradle.daemon=true
org.gradle.parallel=true
org.gradle.caching=true
kotlin.incremental=true
```

### Reduce APK Size
- Enable ProGuard/R8 (already configured in release builds)
- Use App Bundle instead of APK
- Optimize images and resources
- Remove unused resources

## Continuous Integration

### GitHub Actions Example
```yaml
name: Android CI

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build with Gradle
        run: ./gradlew build
      - name: Run tests
        run: ./gradlew test
```

## Resources

- [Android Developer Documentation](https://developer.android.com/docs)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Material Design 3](https://m3.material.io/)
- [Gradle User Manual](https://docs.gradle.org/)

## Support

If you encounter any issues:
1. Check the [Issues](https://github.com/werner073-sys/FEM_Main/issues) page
2. Create a new issue with:
   - Error message
   - Build output
   - Your environment details (OS, Android Studio version, etc.)

## Next Steps

After building successfully:
1. Test the app thoroughly on multiple devices
2. Review the [Play Store Checklist](PLAY_STORE_CHECKLIST.md)
3. Prepare store assets (screenshots, descriptions, etc.)
4. Submit to Google Play Store
