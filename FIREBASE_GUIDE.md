# Firebase App Distribution Setup Guide

This guide will help you set up Firebase App Distribution to test your FEM Android app with testers before releasing to the Play Store.

## What is Firebase App Distribution?

Firebase App Distribution is a tool that makes it easy to distribute pre-release versions of your app to trusted testers. It allows you to:

- Upload APK/AAB files for testing
- Invite testers via email
- Get feedback from testers
- Track which versions testers have installed
- Distribute builds quickly without Play Store delays

## Prerequisites

1. **Google Account** - You need a Google account to access Firebase
2. **Built APK** - You need to build your app first (see [BUILD_GUIDE.md](BUILD_GUIDE.md))
3. **Firebase Project** - You'll create this in the setup below

## Step 1: Build Your App

First, build a debug or release APK:

```bash
# Build debug APK (easier for testing, no signing needed)
./gradlew assembleDebug

# Or build release APK (requires signing)
./gradlew assembleRelease
```

Your APK will be located at:
- Debug: `app/build/outputs/apk/debug/app-debug.apk`
- Release: `app/build/outputs/apk/release/app-release.apk`

## Step 2: Create a Firebase Project

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Click **"Add project"** or **"Create a project"**
3. Enter project name: `FEM App` (or your preferred name)
4. Click **Continue**
5. Enable/disable Google Analytics (optional for testing)
6. Click **Create project**
7. Wait for project creation to complete
8. Click **Continue**

## Step 3: Add Android App to Firebase

1. In your Firebase project dashboard, click the **Android icon** to add an Android app
2. Enter your Android package name: **`com.fem.app`**
3. (Optional) Enter app nickname: `FEM Android`
4. (Optional) Enter SHA-1 certificate fingerprint (not required for App Distribution)
5. Click **Register app**
6. Download the `google-services.json` file
7. Click **Next** (you can skip SDK setup for now)
8. Click **Continue to console**

## Step 4: Place google-services.json in Your Project

1. Copy the downloaded `google-services.json` file
2. Place it in your project's `app/` directory:
   ```
   FEM_Main/
   └── app/
       └── google-services.json  ← Place it here
   ```

## Step 5: Add Firebase Dependencies (Optional)

If you want to integrate Firebase SDK into your app:

**Update build.gradle.kts (root level):**
```kotlin
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
        // Add Firebase
        classpath("com.google.gms:google-services:4.4.0")
    }
}
```

**Update app/build.gradle.kts:**
```kotlin
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services") // Add this line
}

// ... rest of your configuration

dependencies {
    // ... existing dependencies
    
    // Add Firebase dependencies (optional)
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-analytics")
}
```

**Note**: Firebase SDK is optional for just using App Distribution. You only need it if you want Firebase features in your app.

## Step 6: Set Up Firebase App Distribution

### Method 1: Using Firebase Console (Web - Easiest)

1. In Firebase Console, go to **Release & Monitor** → **App Distribution**
2. Click **Get started**
3. Click **Upload your first release**
4. Drag and drop your APK file or click to browse
5. Add release notes (e.g., "Initial release for testing")
6. Choose testers:
   - Click **Add testers**
   - Enter tester email addresses
   - Click **Add**
7. Click **Distribute**

Your testers will receive an email invitation to test the app!

### Method 2: Using Firebase CLI (Advanced)

1. **Install Firebase CLI:**
   ```bash
   npm install -g firebase-tools
   # or
   curl -sL https://firebase.tools | bash
   ```

2. **Login to Firebase:**
   ```bash
   firebase login
   ```

3. **Initialize Firebase in your project:**
   ```bash
   cd /path/to/FEM_Main
   firebase init
   ```
   - Select **App Distribution**
   - Select your Firebase project
   - Follow the prompts

4. **Upload APK using CLI:**
   ```bash
   firebase appdistribution:distribute app/build/outputs/apk/debug/app-debug.apk \
     --app YOUR_FIREBASE_APP_ID \
     --release-notes "Testing build" \
     --testers "tester1@example.com,tester2@example.com"
   ```

   **Find your Firebase App ID:**
   - Go to Firebase Console
   - Click the gear icon → Project settings
   - Scroll down to "Your apps"
   - Copy the App ID (format: `1:123456789:android:abc123def456`)

### Method 3: Using Gradle Plugin (Automated)

1. **Add Firebase App Distribution plugin to app/build.gradle.kts:**

```kotlin
plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services")
    id("com.google.firebase.appdistribution") version "4.0.1" // Add this
}

// ... existing configuration

firebaseAppDistribution {
    artifactType = "APK"
    releaseNotesFile = "./release-notes.txt"
    testers = "tester1@example.com, tester2@example.com"
    // Or use tester groups
    // groups = "qa-team, beta-testers"
}
```

2. **Create release-notes.txt** in your project root:
```
Bug fixes and improvements
Testing new bio-luminescent UI theme
```

3. **Upload using Gradle task:**
```bash
./gradlew assembleDebug appDistributionUploadDebug
```

## Step 7: Invite Testers

### Add Individual Testers
1. Go to Firebase Console → App Distribution
2. Click **Testers & Groups** tab
3. Click **Add testers**
4. Enter email addresses (one per line)
5. Click **Add testers**

### Create Tester Groups
1. Click **Testers & Groups** tab
2. Click **New group**
3. Enter group name (e.g., "QA Team", "Beta Testers")
4. Add testers to the group
5. Click **Save**

## Step 8: Testers Download and Install

### For Testers:

1. **Receive invitation email** from Firebase App Distribution
2. **Click the invitation link** in the email
3. **Sign in with Google account** (if prompted)
4. **Download the Firebase App Tester app**:
   - Android: Install from Play Store
   - Or download APK directly from the invitation

5. **Open Firebase App Tester app**
6. **Accept the invitation**
7. **Download and install FEM app**

### Direct APK Download (Alternative)

Testers can also download the APK directly:

1. Go to the Firebase App Distribution link
2. Click **Download**
3. Enable "Install from unknown sources" on Android device:
   - Settings → Security → Unknown sources → Enable
   - Or Settings → Apps → Special access → Install unknown apps
4. Open the downloaded APK
5. Click **Install**

## Step 9: Collect Feedback

### Testers Can Provide Feedback:

1. Open Firebase App Tester app
2. Select FEM app
3. Click **Send feedback**
4. Add screenshot, description, and device info
5. Submit

### You Can View Feedback:

1. Go to Firebase Console → App Distribution
2. Click on a release
3. View tester feedback and crash reports

## Automated Distribution with CI/CD

### GitHub Actions Example

Create `.github/workflows/firebase-distribution.yml`:

```yaml
name: Deploy to Firebase App Distribution

on:
  push:
    branches: [ main, develop ]
  workflow_dispatch:

jobs:
  build-and-distribute:
    runs-on: ubuntu-latest
    
    steps:
      - name: Checkout code
        uses: actions/checkout@v3
      
      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'
      
      - name: Make gradlew executable
        run: chmod +x ./gradlew
      
      - name: Build debug APK
        run: ./gradlew assembleDebug
      
      - name: Upload to Firebase App Distribution
        uses: wzieba/Firebase-Distribution-Github-Action@v1
        with:
          appId: ${{ secrets.FIREBASE_APP_ID }}
          serviceCredentialsFileContent: ${{ secrets.FIREBASE_CREDENTIALS }}
          groups: beta-testers
          file: app/build/outputs/apk/debug/app-debug.apk
          releaseNotes: "Automated build from commit ${{ github.sha }}"
```

**Set up secrets:**
1. Go to your GitHub repository
2. Settings → Secrets and variables → Actions
3. Add `FIREBASE_APP_ID`
4. Add `FIREBASE_CREDENTIALS` (service account JSON)

## Best Practices

### Release Notes
Always include meaningful release notes:
```
v1.0-beta1
- New bio-luminescent UI theme
- Fixed login issues
- Improved performance
- Known issues: Settings page WIP
```

### Versioning
Update version for each release:
```kotlin
// In app/build.gradle.kts
defaultConfig {
    versionCode = 2  // Increment for each build
    versionName = "1.0-beta2"  // Update version name
}
```

### Testing Checklist
Before distributing:
- [ ] Build successful
- [ ] App installs on test device
- [ ] All core features work
- [ ] No critical crashes
- [ ] Release notes updated
- [ ] Version code incremented

### Tester Instructions Template

Send this to your testers:

```
Subject: Test FEM App - Beta Release

Hi Team,

I've uploaded a new build of the FEM app for testing.

📱 How to install:
1. Check your email for Firebase App Distribution invitation
2. Install Firebase App Tester app from Play Store
3. Accept the invitation and download FEM app
4. Test the app and provide feedback

🎯 What to test:
- Bio-luminescent UI theme
- Button interactions
- Overall user experience

🐛 Found a bug?
1. Open Firebase App Tester app
2. Select FEM app → Send feedback
3. Include screenshots and description

Version: 1.0-beta1
Release notes: [Add your release notes]

Let me know if you have any questions!
```

## Troubleshooting

### Issue: Testers can't install the app
**Solutions:**
- Enable "Install from unknown sources" in Android settings
- Check if device meets minimum SDK requirements (API 24/Android 7.0)
- Try uninstalling previous version first

### Issue: Upload fails
**Solutions:**
- Check internet connection
- Verify Firebase App ID is correct
- Ensure `google-services.json` is in the correct location
- Check Firebase CLI is logged in: `firebase login:list`

### Issue: Testers don't receive invitation
**Solutions:**
- Check spam folder
- Verify email addresses are correct
- Resend invitation from Firebase Console
- Add testers to a group first

### Issue: Build failed
**Solutions:**
- See [BUILD_GUIDE.md](BUILD_GUIDE.md)
- See [FIREWALL_GUIDE.md](FIREWALL_GUIDE.md) for network issues

## Quick Reference Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Upload via Firebase CLI
firebase appdistribution:distribute app/build/outputs/apk/debug/app-debug.apk \
  --app YOUR_APP_ID \
  --groups "beta-testers"

# Upload via Gradle
./gradlew appDistributionUploadDebug

# Check Firebase CLI login
firebase login:list

# Logout from Firebase
firebase logout
```

## Security Considerations

1. **Don't commit google-services.json** - Add to .gitignore
2. **Use debug builds for testing** - Easier to install and debug
3. **Limit tester access** - Only invite trusted testers
4. **Use groups** - Easier to manage large tester bases
5. **Monitor feedback** - Address security issues reported by testers

## Cost

Firebase App Distribution is **FREE** with generous limits:
- Unlimited distributions
- Unlimited testers
- 200MB per app binary
- 2GB storage for releases

## Additional Resources

- [Firebase App Distribution Documentation](https://firebase.google.com/docs/app-distribution)
- [Firebase Console](https://console.firebase.google.com/)
- [Firebase CLI Reference](https://firebase.google.com/docs/cli)
- [Android App Distribution Guide](https://firebase.google.com/docs/app-distribution/android/distribute-console)

## Next Steps

After testing with Firebase App Distribution:

1. Collect and address feedback
2. Fix bugs and iterate
3. When ready, follow [PLAY_STORE_CHECKLIST.md](PLAY_STORE_CHECKLIST.md)
4. Submit to Google Play Store for public release

## Summary

Firebase App Distribution workflow:
1. Build APK → 2. Upload to Firebase → 3. Invite testers → 4. Collect feedback → 5. Iterate

This process helps you test your app with real users before releasing to the Play Store!
