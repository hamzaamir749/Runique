# Runique 🏃‍♂️

**Runique** is a modern, feature-rich Android running tracker built with **Kotlin**, **Jetpack Compose**, and **Clean Architecture**. It helps users track their runs in real time, view historical workout metrics, analyze performance data, and manage user authentication securely.

---

## 📱 Features

- **🔐 Authentication**:
  - Clean onboarding, account creation, and login flow.
  - Form validation with real-time feedback (email format, password complexity requirements).
  - Encrypted local session storage for tokens and user credentials.

- **🏃 Active Run Tracking**:
  - Real-time GPS location tracking using Google Play Services Location API.
  - Live display of run duration, current distance, and average pace.
  - Persistent foreground tracking service ensuring seamless tracking even when the app is in the background.

- **📊 Run Overview & History**:
  - Detailed overview of past runs.
  - Track stats such as total running time, distance, pace, average speed, max speed, and total elevation.
  - Interactive map preview of completed run paths.

- **📈 Analytics Dashboard**:
  - Comprehensive metrics overview:
    - Total distance run
    - Total time run
    - Fastest ever run speed
    - Average distance per run
    - Average pace per run

---

## 🏗️ Architecture & Project Structure

The project follows **Clean Architecture** principles and is fully modularized by feature and layer:

```
Runique/
├── app/                              # Main application entry point & navigation graph
├── auth/                             # Authentication feature module
│   ├── data/                         # Auth repository implementation & API calls
│   ├── domain/                       # Auth use cases, models & validators
│   └── presentation/                 # Intro, Login, and Register Compose UI screens
├── run/                              # Run tracking feature module
│   ├── data/                         # Offline-first run repository
│   ├── domain/                       # Run tracking models & logic
│   ├── location/                     # Location tracking service & location client
│   ├── network/                      # Remote run data sources & Ktor client logic
│   └── presentation/                 # Active Run & Run Overview Compose UI screens
├── analytics/                        # Analytics feature module (includes dynamic feature)
│   ├── data/                         # Analytics data mapping
│   ├── domain/                       # Analytics calculation engine
│   ├── presentation/                 # Analytics dashboard Compose UI screen
│   └── analytics_feature/            # Dynamic feature module for analytics
├── core/                             # Core cross-cutting modules
│   ├── database/                     # Room database & DAOs
│   ├── data/                         # Shared networking (HttpClientFactory) & session storage
│   ├── domain/                       # Shared domain models & utility wrappers
│   └── presentation/                 # Shared design system components & themes
└── build-logic/                      # Custom Gradle convention plugins for builds
```

---

## 🛠️ Tech Stack & Libraries

- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material 3 design system.
- **Language**: 100% Kotlin with Coroutines and Flow.
- **Dependency Injection**: [Koin](https://insert-koin.io/) for modular DI.
- **Networking**: [Ktor Client](https://ktor.io/) with automatic Bearer token refreshing and `kotlinx.serialization`.
- **Database & Storage**: [Room](https://developer.android.com/training/data-storage/room) & Android Security Crypto (`EncryptedSharedPreferences`).
- **Location**: Google Play Services Location (`FusedLocationProviderClient`).
- **Build System**: Gradle with Kotlin DSL and type-safe project accessors.

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Studio (latest version recommended)
- JDK 17 or higher
- Android SDK 34+

### Configuration

1. Clone the repository:
   ```bash
   git clone https://github.com/coderpakistan/Runique.git
   cd Runique
   ```

2. Add your `API_KEY` in `local.properties`:
   ```properties
   API_KEY=your_api_key_here
   MAPS_API_KEY=your_maps_api_key_here
   ```

3. Build and run the application:
   ```bash
   ./gradlew assembleDebug
   ```

---

## 📄 License

This project is licensed under the MIT License.
