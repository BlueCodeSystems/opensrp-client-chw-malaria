 Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## [2.0.0] - 2025-09-07

### Breaking changes
- Raised `minSdk` to 28 (from previous lower value) to align with modern dependencies and AGP. Consumers targeting devices < 28 will be affected.
- Migrated codebase and resources from legacy `android.support.*` to AndroidX. Projects must use AndroidX.
- Upgraded build toolchain to Gradle 8.7 and Android Gradle Plugin 8.6. Requires JDK 17 to build.

### Fixes
- Resolved JDK 17 unit test crash (`NoClassDefFoundError: jdk/internal/reflect/GeneratedSerializationConstructorAccessor1`) by updating JaCoCo to 0.8.10 and excluding `jdk.internal.*` from instrumentation.

### Tests
- Migrated Android-dependent unit tests to Robolectric; removed PowerMock usage; added a lightweight test `Application` to initialize SmartRegister Core during tests.

### Dependencies and build
- Target/compile SDK updated to 35; Material 1.12.0 and other AndroidX libs aligned.
- Gradle/JVM args updated for JDK 17 module opens across test workers.
- JitPack CI improved by installing `platform-tools` and ensuring the Gradle wrapper is executable; artifacts are published to `~/.m2` via `publishToMavenLocal`.

[Release tag]
- https://github.com/BlueCodeSystems/opensrp-client-chw-malaria/releases/tag/v2.0.0
