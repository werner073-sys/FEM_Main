# Contributing to FEM

Thank you for your interest in contributing to FEM! This document provides guidelines and instructions for contributing to this project.

## Code of Conduct

By participating in this project, you agree to maintain a respectful and inclusive environment for everyone.

## How to Contribute

### Reporting Bugs

If you find a bug:
1. Check if the bug has already been reported in [Issues](https://github.com/werner073-sys/FEM_Main/issues)
2. If not, create a new issue with:
   - Clear, descriptive title
   - Steps to reproduce
   - Expected behavior
   - Actual behavior
   - Screenshots (if applicable)
   - Device and OS information
   - App version

### Suggesting Enhancements

To suggest a new feature:
1. Check existing issues to avoid duplicates
2. Create a new issue labeled "enhancement" with:
   - Clear description of the feature
   - Use cases and benefits
   - Potential implementation approach

### Pull Requests

1. **Fork the repository**
   ```bash
   git clone https://github.com/werner073-sys/FEM_Main.git
   cd FEM_Main
   ```

2. **Create a feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make your changes**
   - Follow the coding standards (see below)
   - Add tests if applicable
   - Update documentation

4. **Test your changes**
   ```bash
   ./gradlew test
   ./gradlew lint
   ```

5. **Commit your changes**
   ```bash
   git add .
   git commit -m "Add feature: description of your changes"
   ```

6. **Push to your fork**
   ```bash
   git push origin feature/your-feature-name
   ```

7. **Create a Pull Request**
   - Go to the original repository
   - Click "New Pull Request"
   - Select your fork and branch
   - Provide a clear description of changes

## Coding Standards

### Kotlin Style Guide
- Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable and function names
- Add comments for complex logic
- Keep functions small and focused

### Code Structure
```kotlin
// Good example
class UserProfile {
    private val TAG = "UserProfile"
    
    fun updateProfile(user: User): Result<Unit> {
        return try {
            // Implementation
            Result.success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to update profile", e)
            Result.failure(e)
        }
    }
}
```

### Android Best Practices
- Use ViewBinding instead of findViewById
- Follow MVVM or MVI architecture patterns
- Handle configuration changes properly
- Use lifecycle-aware components
- Implement proper error handling

### Resource Naming
- Layouts: `activity_main.xml`, `fragment_profile.xml`
- IDs: `btnSubmit`, `tvTitle`, `etEmail`
- Drawables: `ic_launcher`, `bg_gradient`, `btn_primary`
- Colors: `primary`, `secondary`, `background`
- Strings: `app_name`, `error_message`, `button_submit`

### Git Commit Messages
```
Format: <type>: <subject>

Types:
- feat: New feature
- fix: Bug fix
- docs: Documentation changes
- style: Code formatting
- refactor: Code restructuring
- test: Adding tests
- chore: Maintenance tasks

Example:
feat: Add user profile screen
fix: Resolve crash on app startup
docs: Update README with build instructions
```

## Testing

### Unit Tests
- Write tests for business logic
- Use JUnit and MockK
- Aim for >70% code coverage

```kotlin
@Test
fun `test user login with valid credentials`() {
    // Arrange
    val user = User("test@example.com", "password")
    
    // Act
    val result = authService.login(user)
    
    // Assert
    assertTrue(result.isSuccess)
}
```

### UI Tests
- Write UI tests for critical user flows
- Use Espresso or Compose UI Testing

## Documentation

- Update README.md for major changes
- Add KDoc comments for public APIs
- Update BUILD_GUIDE.md if build process changes
- Include screenshots for UI changes

## Review Process

1. Automated checks must pass (build, tests, lint)
2. Code review by maintainers
3. Address feedback
4. Merge when approved

## Project Structure

```
FEM_Main/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/fem/app/  # Kotlin source files
│   │   │   ├── res/                # Resources
│   │   │   └── AndroidManifest.xml
│   │   └── test/                   # Unit tests
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Questions?

If you have questions:
- Check existing issues and documentation
- Ask in issue comments
- Contact maintainers

## License

By contributing, you agree that your contributions will be licensed under the same license as the project (see LICENSE file).

Thank you for contributing to FEM! 🎉
