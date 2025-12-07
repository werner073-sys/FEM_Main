# Firewall and Network Configuration Guide

This guide helps you configure your network, firewall, and proxy settings to successfully build the FEM Android app.

## Quick Diagnosis

If your build fails with errors like:
- `Could not GET 'https://dl.google.com/...'`
- `Could not resolve com.android.tools.build:gradle:...`
- `Connection timeout` or `Connection refused`
- `UnknownHostException: dl.google.com`

You likely have firewall or proxy blocking issues.

## Required Network Access

The Android build process needs to download dependencies from external repositories. Here's what you need:

### Required Domains (HTTPS - Port 443)

| Domain | Purpose | Priority |
|--------|---------|----------|
| `dl.google.com` | Google Maven (Android Gradle Plugin, Google Play Services, AndroidX) | **Critical** |
| `repo.maven.apache.org` | Maven Central (Kotlin, third-party libraries) | **Critical** |
| `services.gradle.org` | Gradle wrapper distributions | **Critical** |
| `repo1.maven.org` | Maven Central mirror | High |
| `plugins.gradle.org` | Gradle plugins | Medium |
| `jcenter.bintray.com` | JCenter (legacy, rarely needed) | Low |

### Test Your Connectivity

Run these commands to verify access:

```bash
# Test Google Maven (most important)
curl -I https://dl.google.com/dl/android/maven2/com/android/tools/build/gradle/7.4.2/gradle-7.4.2.pom

# Test Maven Central
curl -I https://repo.maven.apache.org/maven2/org/jetbrains/kotlin/kotlin-gradle-plugin/1.8.20/kotlin-gradle-plugin-1.8.20.pom

# Test Gradle services
curl -I https://services.gradle.org/distributions/gradle-8.0-bin.zip

# If all fail, you're behind a firewall or proxy
```

## Solution 1: Configure Proxy in Gradle

### Method A: Project-level Configuration

Create or edit `gradle.properties` in your project root:

```properties
# Basic proxy configuration
systemProp.http.proxyHost=proxy.yourcompany.com
systemProp.http.proxyPort=8080
systemProp.https.proxyHost=proxy.yourcompany.com
systemProp.https.proxyPort=8080

# With authentication (if required)
systemProp.http.proxyUser=your_username
systemProp.http.proxyPassword=your_password
systemProp.https.proxyUser=your_username
systemProp.https.proxyPassword=your_password

# Bypass proxy for local addresses
systemProp.http.nonProxyHosts=*.local|localhost|127.0.0.1
```

**Security Note**: Don't commit passwords to git! Use environment variables instead:

```properties
systemProp.http.proxyUser=${PROXY_USER}
systemProp.http.proxyPassword=${PROXY_PASSWORD}
```

### Method B: User-level Configuration

Edit `~/.gradle/gradle.properties` (Linux/Mac) or `C:\Users\YourName\.gradle\gradle.properties` (Windows):

```properties
systemProp.http.proxyHost=proxy.yourcompany.com
systemProp.http.proxyPort=8080
systemProp.https.proxyHost=proxy.yourcompany.com
systemProp.https.proxyPort=8080
```

This applies to all Gradle projects on your system.

### Method C: Environment Variables

**Linux/macOS:**
```bash
export GRADLE_OPTS="-Dhttp.proxyHost=proxy.yourcompany.com -Dhttp.proxyPort=8080 -Dhttps.proxyHost=proxy.yourcompany.com -Dhttps.proxyPort=8080"

# With authentication
export GRADLE_OPTS="-Dhttp.proxyHost=proxy.yourcompany.com -Dhttp.proxyPort=8080 -Dhttp.proxyUser=username -Dhttp.proxyPassword=password -Dhttps.proxyHost=proxy.yourcompany.com -Dhttps.proxyPort=8080 -Dhttps.proxyUser=username -Dhttps.proxyPassword=password"
```

**Windows (PowerShell):**
```powershell
$env:GRADLE_OPTS="-Dhttp.proxyHost=proxy.yourcompany.com -Dhttp.proxyPort=8080 -Dhttps.proxyHost=proxy.yourcompany.com -Dhttps.proxyPort=8080"
```

**Windows (Command Prompt):**
```cmd
set GRADLE_OPTS=-Dhttp.proxyHost=proxy.yourcompany.com -Dhttp.proxyPort=8080 -Dhttps.proxyHost=proxy.yourcompany.com -Dhttps.proxyPort=8080
```

## Solution 2: Configure Proxy in Android Studio

1. Open Android Studio
2. Go to **File → Settings** (Windows/Linux) or **Android Studio → Preferences** (macOS)
3. Navigate to **Appearance & Behavior → System Settings → HTTP Proxy**
4. Select **Manual proxy configuration**
5. Enter proxy details:
   - Host name: `proxy.yourcompany.com`
   - Port number: `8080`
6. Add authentication if required
7. Add exception hosts if needed (e.g., `localhost, 127.0.0.1`)
8. Click **Check connection** to test
9. Click **OK** to save

Android Studio will automatically configure Gradle to use these settings.

## Solution 3: Firewall Configuration

If you control your firewall, configure it to allow outbound HTTPS (port 443) connections.

### Corporate IT Request Template

```
Subject: Firewall Access Request for Android Development

Hello IT Team,

I need access to the following domains for Android app development:

Critical (Required):
- dl.google.com (Google Maven Repository - Android libraries)
- repo.maven.apache.org (Maven Central - Third-party libraries)
- services.gradle.org (Gradle build tool distributions)

Additional (Recommended):
- repo1.maven.org (Maven Central mirror)
- plugins.gradle.org (Gradle plugins)
- jcenter.bintray.com (Legacy repository)

Protocol: HTTPS (Port 443)
Direction: Outbound only
Purpose: Download Android build dependencies

These are standard requirements for Android development and are safe, 
well-known repositories maintained by Google and the open-source community.

Thank you!
```

## Solution 4: Use a Maven Mirror

If external access is not allowed, set up an internal Maven repository mirror (Nexus, Artifactory, or similar).

### Configure Your Build Files

**build.gradle.kts:**
```kotlin
buildscript {
    repositories {
        // Remove or comment out public repositories
        // google()
        // mavenCentral()
        
        // Add your internal mirror
        maven {
            url = uri("https://maven.yourcompany.com/repository/maven-public/")
            credentials {
                username = project.findProperty("repoUser") as String? ?: System.getenv("REPO_USER")
                password = project.findProperty("repoPassword") as String? ?: System.getenv("REPO_PASSWORD")
            }
        }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
    }
}

allprojects {
    repositories {
        maven {
            url = uri("https://maven.yourcompany.com/repository/maven-public/")
            credentials {
                username = project.findProperty("repoUser") as String? ?: System.getenv("REPO_USER")
                password = project.findProperty("repoPassword") as String? ?: System.getenv("REPO_PASSWORD")
            }
        }
    }
}
```

**settings.gradle.kts:**
```kotlin
pluginManagement {
    repositories {
        maven {
            url = uri("https://maven.yourcompany.com/repository/maven-public/")
        }
    }
}
```

**gradle.properties (don't commit credentials!):**
```properties
repoUser=your_username
repoPassword=your_password
```

Or use environment variables:
```bash
export REPO_USER=your_username
export REPO_PASSWORD=your_password
```

## Solution 5: Offline Build (Advanced)

If you have no network access, you can build offline after downloading all dependencies once on a machine with internet access.

### Step 1: Download Dependencies (on machine with internet)
```bash
./gradlew build --refresh-dependencies
```

### Step 2: Copy Gradle Cache
Copy the Gradle cache to the offline machine:
- Linux/Mac: `~/.gradle/`
- Windows: `C:\Users\YourName\.gradle\`

### Step 3: Build Offline
```bash
./gradlew build --offline
```

## Verify Your Configuration

After configuring, test your setup:

```bash
# Clean previous build artifacts
./gradlew clean

# Attempt to build (will download dependencies)
./gradlew build --info

# Check for dependency resolution messages
# You should see successful downloads from your repositories
```

Look for messages like:
- ✅ `Download https://dl.google.com/... succeeded`
- ✅ `Resolved com.android.tools.build:gradle:7.4.2`
- ❌ `Could not GET 'https://...'` (indicates still blocked)

## Common Proxy Authentication Issues

### Issue: Authentication Required (407)
**Solution**: Add proxy credentials to gradle.properties

### Issue: NTLM Authentication
Some corporate proxies use NTLM authentication which Gradle doesn't support directly.

**Workaround**: Use a local proxy tool like CNTLM that handles NTLM and provides a simple HTTP proxy:

1. Install CNTLM: http://cntlm.sourceforge.net/
2. Configure CNTLM with your corporate proxy and NTLM credentials
3. Point Gradle to CNTLM (usually localhost:3128)

```properties
systemProp.http.proxyHost=localhost
systemProp.http.proxyPort=3128
systemProp.https.proxyHost=localhost
systemProp.https.proxyPort=3128
```

### Issue: SSL Certificate Verification
If you get SSL certificate errors:

**NOT RECOMMENDED for production**, but for development:
```properties
systemProp.javax.net.ssl.trustStore=/path/to/your/truststore
systemProp.javax.net.ssl.trustStorePassword=changeit
```

Better solution: Add your corporate SSL certificates to Java's truststore.

## Quick Reference

### Identify Your Proxy Settings

**Windows:**
1. Control Panel → Internet Options → Connections → LAN Settings
2. Check if "Use a proxy server" is enabled
3. Note the address and port

**macOS:**
1. System Preferences → Network → Advanced → Proxies
2. Check which proxies are enabled
3. Note the server and port

**Linux:**
```bash
echo $http_proxy
echo $https_proxy
```

### Common Proxy Ports
- 8080 (most common)
- 3128 (Squid default)
- 80 (HTTP)
- 8888 (alternative)

## Still Having Issues?

### Debug Steps

1. **Test basic connectivity:**
   ```bash
   ping dl.google.com
   curl -v https://dl.google.com
   ```

2. **Run Gradle with debug logging:**
   ```bash
   ./gradlew build --debug > build_debug.log 2>&1
   ```
   Check the log for connection errors.

3. **Verify proxy settings:**
   ```bash
   ./gradlew -Dorg.gradle.debug=true
   ```

4. **Check DNS resolution:**
   ```bash
   nslookup dl.google.com
   nslookup repo.maven.apache.org
   ```

5. **Test with curl through proxy:**
   ```bash
   curl -x http://proxy.company.com:8080 https://dl.google.com
   ```

### Get Help

If none of these solutions work:

1. Contact your IT department with the firewall access request template above
2. Ask them if they have an internal Maven mirror you should use
3. Check if your company has a VPN that allows direct internet access
4. Consider building the app on a personal machine with internet access

## Security Best Practices

1. ✅ **Never commit passwords to git**
   - Use environment variables
   - Use gradle.properties in .gitignore
   - Use a secrets management system

2. ✅ **Use HTTPS repositories only**
   - Avoid HTTP repositories (security risk)

3. ✅ **Verify SSL certificates**
   - Don't disable SSL verification in production

4. ✅ **Keep credentials secure**
   - Use encrypted storage
   - Rotate passwords regularly
   - Use service accounts for CI/CD

## Additional Resources

- [Gradle Proxy Configuration](https://docs.gradle.org/current/userguide/build_environment.html#sec:accessing_the_web_via_a_proxy)
- [Android Studio Proxy Settings](https://developer.android.com/studio/intro/studio-config#proxy)
- [Maven Repository Manager](https://maven.apache.org/repository-management.html)

## Summary

Most firewall/proxy issues can be resolved by:
1. Configuring proxy settings in `gradle.properties`
2. Requesting firewall access to required domains
3. Using your company's internal Maven mirror

Choose the solution that best fits your environment and security policies.
