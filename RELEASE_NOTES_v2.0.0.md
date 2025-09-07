## v2.0.0 (2025-09-07)

This release introduces AndroidX migration, modernizes the build toolchain for JDK 17, and stabilizes unit testing.

Breaking changes
- AndroidX-only. Consuming apps must enable AndroidX.
- minSdk 28. Aligned with modern dependencies and AGP requirements.
- Build toolchain requires JDK 17, Gradle 8.7, and Android Gradle Plugin 8.6.

Fixes
- Resolved JaCoCo/JDK 17 crash by upgrading JaCoCo and excluding `jdk.internal.*` from instrumentation.

Tests
- Migrated unit tests to Robolectric; removed PowerMock; added a lightweight test Application to initialize SmartRegister Core.

Build/CI
- JitPack installs platform-tools and publishes to `~/.m2` via `publishToMavenLocal`.
- Shared JDK 17 JVM args for test workers, improved memory settings.

Coordinates
- JitPack: `com.github.BlueCodeSystems:opensrp-client-chw-malaria:2.0.0`

Links
- Tag: https://github.com/BlueCodeSystems/opensrp-client-chw-malaria/releases/tag/v2.0.0
- JitPack: https://jitpack.io/#BlueCodeSystems/opensrp-client-chw-malaria/v2.0.0
