# How to Get the APK

This guide explains different ways to obtain the FEM Android APK file.

## Option 1: Download from GitHub Actions (Easiest)

GitHub Actions automatically builds the APK whenever code is pushed to the repository.

### Steps:

1. **Go to the repository**: https://github.com/werner073-sys/FEM_Main

2. **Click on "Actions" tab** at the top of the repository

3. **Select the "Build Android APK" workflow** from the left sidebar

4. **Click on the most recent successful run** (green checkmark ✓)

5. **Scroll down to "Artifacts" section**

6. **Download the artifact:**
   - `app-debug` - Contains the debug APK (recommended for testing)
   - `app-release-unsigned` - Contains the release APK (needs signing)
   - `build-info` - Contains build information

7. **Extract the ZIP file** to get the APK

8. **Transfer to your Android device** and install

### Installing the APK on Android:

1. Transfer `app-debug.apk` to your device (via USB, email, or cloud storage)
2. Open the APK file on your device
3. If prompted, enable "Install from unknown sources":
   - **Android 8.0+**: Settings → Apps → Special access → Install unknown apps
   - **Android 7.0**: Settings → Security → Unknown sources → Enable
4. Tap "Install"
5. Open the app from your home screen or app drawer

## Option 2: Build Locally

If you want to build the APK on your own machine:

### Prerequisites:
- JDK 11 or higher
- Android SDK with API 34
- Internet connection

### Steps:

```bash
# 1. Clone the repository
git clone https://github.com/werner073-sys/FEM_Main.git
cd FEM_Main

# 2. Build debug APK
./gradlew assembleDebug

# 3. Find your APK
# Location: app/build/outputs/apk/debug/app-debug.apk
```

For detailed build instructions, see [BUILD_GUIDE.md](BUILD_GUIDE.md).

### Building Release APK:

For a release build (optimized, smaller size):

```bash
# Build release APK
./gradlew assembleRelease

# Location: app/build/outputs/apk/release/app-release-unsigned.apk
```

**Note:** Release builds need to be signed before installation. See [BUILD_GUIDE.md](BUILD_GUIDE.md) for signing instructions.

## Option 3: Download from Firebase App Distribution

If the app has been uploaded to Firebase App Distribution:

1. Check your email for Firebase invitation
2. Click the invitation link
3. Install Firebase App Tester app from Play Store
4. Download and install FEM app through App Tester

See [FIREBASE_GUIDE.md](FIREBASE_GUIDE.md) for complete Firebase setup.

## Option 4: Download from GitHub Releases

If a release has been published:

1. Go to https://github.com/werner073-sys/FEM_Main/releases
2. Find the latest release
3. Download the APK from the "Assets" section
4. Install on your Android device

## Troubleshooting

### Cannot download from GitHub Actions
- **Issue**: "Artifacts are only available to signed-in users"
- **Solution**: You need a GitHub account and must be signed in

### APK won't install
- **Issue**: "App not installed" or "Installation blocked"
- **Solutions**:
  - Enable "Install from unknown sources" in Settings
  - Check if you have enough storage space
  - Uninstall any previous version first
  - Try the debug APK instead of release

### Build failed locally
- **Issue**: Gradle build errors
- **Solutions**:
  - Check internet connection (needs to download dependencies)
  - See [BUILD_GUIDE.md](BUILD_GUIDE.md) for detailed troubleshooting
  - See [FIREWALL_GUIDE.md](FIREWALL_GUIDE.md) if behind a firewall

### "App is harmful" warning
- This is normal for apps not from Play Store
- Click "Install anyway" or "More details" → "Install anyway"
- The app is safe - it's just not verified by Google Play

## APK Information

- **Package Name**: com.fem.app
- **Version**: 1.0 (versionCode 1)
- **Min SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)
- **Size**: ~5-10 MB (debug), ~2-5 MB (release)
- **Permissions**: INTERNET only

## Debug vs Release APK

| Feature | Debug APK | Release APK |
|---------|-----------|-------------|
| Size | Larger (~10 MB) | Smaller (~3 MB) |
| Performance | Slower | Faster |
| Signing | Auto-signed | Needs manual signing |
| Installation | Easy | Requires signing first |
| Use Case | Testing, development | Production, distribution |
| ProGuard | Disabled | Enabled (obfuscation) |

**Recommendation**: Use **debug APK** for testing. It's easier to install and debug.

## Security Note

- Only install APKs from trusted sources
- Verify the package name is `com.fem.app`
- Check the app permissions before installing
- The official repository: https://github.com/werner073-sys/FEM_Main

## Next Steps

After installing:
1. Open the FEM app
2. Test all features
3. Provide feedback via GitHub Issues
4. Check [FIREBASE_GUIDE.md](FIREBASE_GUIDE.md) for testing with Firebase
5. See [PLAY_STORE_CHECKLIST.md](PLAY_STORE_CHECKLIST.md) for Play Store submission

## Automatic Builds

The GitHub Actions workflow automatically builds APKs on:
- Every push to `main`, `develop`, or feature branches
- Every pull request to `main`
- Manual trigger via "Actions" tab → "Build Android APK" → "Run workflow"

Build artifacts are retained for 30 days.

## Manual Workflow Trigger

To manually trigger a build:

1. Go to **Actions** tab
2. Click **"Build Android APK"** workflow
3. Click **"Run workflow"** button
4. Select branch (e.g., `copilot/improve-app-functionality`)
5. Click **"Run workflow"**
6. Wait for build to complete (~5-10 minutes)
7. Download artifacts from the completed run

## FAQ

**Q: Which APK should I download?**  
A: Download `app-debug` for testing. It's easier to install.

**Q: How do I sign the release APK?**  
A: See [BUILD_GUIDE.md](BUILD_GUIDE.md) section on "App Signing".

**Q: Can I install on iOS?**  
A: No, this is an Android app only. iOS requires a separate app.

**Q: Is the APK safe?**  
A: Yes, built from open-source code in this repository.

**Q: Why does Google Play Protect warn me?**  
A: The app isn't verified by Google Play yet. Click "Install anyway".

**Q: Can I distribute this APK?**  
A: For personal testing, yes. For public distribution, upload to Play Store.

## Support

If you encounter issues:
1. Check [BUILD_GUIDE.md](BUILD_GUIDE.md)
2. Check [FIREWALL_GUIDE.md](FIREWALL_GUIDE.md) 
3. Open an issue: https://github.com/werner073-sys/FEM_Main/issues

## Build Status

Check the latest build status:
- [![Build Status](https://github.com/werner073-sys/FEM_Main/actions/workflows/build-apk.yml/badge.svg)](https://github.com/werner073-sys/FEM_Main/actions)

Green badge = APK is available for download!
