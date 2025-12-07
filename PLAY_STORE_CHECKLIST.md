# Play Store Submission Checklist

## Pre-Submission Requirements

### App Content
- [ ] App name: FEM
- [ ] Short description (80 characters max)
- [ ] Full description (4000 characters max)
- [ ] App icon (512x512 PNG)
- [ ] Feature graphic (1024x500 PNG)
- [ ] Screenshots (minimum 2, recommended 8)
  - [ ] Phone screenshots
  - [ ] Tablet screenshots (optional)
- [ ] Promo video (optional)

### Technical Requirements
- [x] Target SDK: API 34 (Android 14)
- [x] Min SDK: API 24 (Android 7.0)
- [x] Permissions declared in manifest
- [x] App signing configured
- [ ] Release APK or AAB generated
- [ ] ProGuard/R8 enabled for release
- [ ] App tested on multiple devices

### Store Listing
- [ ] App category selected
- [ ] Content rating completed
- [ ] Privacy policy URL added
- [ ] Contact email provided
- [ ] Target audience defined
- [ ] App access (free/paid) specified

### Legal and Compliance
- [x] Privacy policy created
- [ ] Terms of service created
- [ ] GDPR compliance (if applicable)
- [ ] COPPA compliance (if applicable)
- [ ] Content guidelines compliance
- [ ] App permissions justification

### App Quality
- [ ] No crashes or ANR (Application Not Responding)
- [ ] Proper back button handling
- [ ] Responsive UI on different screen sizes
- [ ] Proper orientation handling
- [ ] Accessibility features implemented
- [ ] Performance optimization

### Release Process
1. [ ] Build signed release APK/AAB:
   ```bash
   ./gradlew bundleRelease
   ```

2. [ ] Test release build thoroughly

3. [ ] Upload to Play Console:
   - Internal testing track (alpha)
   - Closed testing track (beta)
   - Open testing track
   - Production

4. [ ] Configure release:
   - Release notes
   - Rollout percentage
   - Update priority

5. [ ] Submit for review

## Google Play Console Setup

### Account Setup
- [ ] Create Google Play Developer account ($25 one-time fee)
- [ ] Accept Developer Distribution Agreement
- [ ] Complete account details

### App Setup
- [ ] Create app in Play Console
- [ ] Complete all setup tasks
- [ ] Add store listing information
- [ ] Complete content rating questionnaire
- [ ] Set pricing and distribution

### App Signing
- [ ] Upload app signing key
- [ ] Enable Google Play App Signing (recommended)
- [ ] Keep keystore file secure

## Post-Launch
- [ ] Monitor crash reports
- [ ] Respond to user reviews
- [ ] Track key metrics
- [ ] Plan updates and improvements
- [ ] Monitor Play Console for policy updates

## Important Links
- [Google Play Console](https://play.google.com/console)
- [Android Developer Policy](https://play.google.com/about/developer-content-policy/)
- [Launch Checklist](https://developer.android.com/distribute/best-practices/launch/launch-checklist)

## Notes
- Review process typically takes 1-3 days
- Ensure all content complies with Google Play policies
- Keep app updated with latest Android features and security patches
- Respond to user feedback promptly
