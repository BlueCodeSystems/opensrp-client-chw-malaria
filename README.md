# OpenSRP Client CHW Malaria

[![JitPack Latest](https://jitpack.io/v/BlueCodeSystems/opensrp-client-chw-malaria.svg)](https://jitpack.io/#BlueCodeSystems/opensrp-client-chw-malaria)
[![Build for latest tag (v2.0.0)](https://jitpack.io/v/BlueCodeSystems/opensrp-client-chw-malaria/v2.0.0.svg)](https://jitpack.io/#BlueCodeSystems/opensrp-client-chw-malaria/v2.0.0)
[![master-SNAPSHOT](https://jitpack.io/v/BlueCodeSystems/opensrp-client-chw-malaria/master-SNAPSHOT.svg)](https://jitpack.io/#BlueCodeSystems/opensrp-client-chw-malaria/master-SNAPSHOT)

Android library providing CHW malaria features for OpenSRP-based apps.

Version 2.x highlights
- AndroidX-only (migrated from legacy support libs).
- Requires JDK 17, Gradle 8.7, AGP 8.6.
- compileSdk/targetSdk 35; minSdk 28.

Requirements
- JDK 17
- Android Gradle Plugin 8.6 (via project Gradle wrapper 8.7)
- Android SDK 35 and Build Tools 35.0.0
- AndroidX enabled in consuming apps (`android.useAndroidX=true`, `android.enableJetifier=true` if migrating)

Getting started
1) Add the repository
- JitPack (recommended for tagged releases):
```
repositories {
    maven { url 'https://jitpack.io' }
}
```

2) Add the dependency
- Default (this repository under BlueCodeSystems):
```
dependencies {
    implementation 'com.github.BlueCodeSystems:opensrp-client-chw-malaria:2.0.0'
}
```
- If you consume from a different fork, replace `BlueCodeSystems` with your GitHub org/user.

Alternative: local Maven (developer workflow)
```
./gradlew :opensrp-chw-malaria:publishToMavenLocal
```
Then in your app/module (uses this project's configured group):
```
repositories { mavenLocal() }
dependencies {
    implementation 'com.github.BlueCodeSystems:opensrp-client-chw-malaria:2.0.0'
}
```

Test and build
- Unit tests: `./gradlew :opensrp-chw-malaria:testDebugUnitTest`
  - Robolectric is configured; a test `Application` initializes CoreLibrary for tests that call `onCreate()`.
- Lint: `./gradlew :opensrp-chw-malaria:lint`
- Sample app: `./gradlew :sample:assembleDebug`

Migration notes (1.x → 2.x)
- AndroidX is required. Ensure `android.useAndroidX=true` and migrate imports.
- minSdk is now 28 to align with transitive dependencies and AGP requirements.
- Build with JDK 17 and recent Android Studio (or the included Gradle wrapper).

Releases
- See CHANGELOG.md for changes. Tags use the form `vX.Y.Z`.

License
- Apache-2.0. See LICENSE file.
