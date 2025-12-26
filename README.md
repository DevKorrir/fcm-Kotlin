# FCM Demo

This is a simple Android application demonstrating the use of Firebase Cloud Messaging (FCM) with Jetpack Compose.

## Features

* **Firebase Cloud Messaging:** The app is configured to receive push notifications from FCM.
* **Push Notification Permission:** The app requests the required push notification permission from the user on devices running Android 13 and above.
* **Topic Subscription:** The app subscribes to the "news" topic to receive relevant notifications.

## Setup

1.  **Firebase Project:**
    *   Create a new Firebase project in the [Firebase console](https://console.firebase.google.com/).
    *   Add an Android app to your Firebase project, making sure to use `dev.korryr.fcm` as the package name.
    *   Download the `google-services.json` file and place it in the `app` directory of this project.
2.  **Building the Project:**
    *   This project can be built using Android Studio or from the command line using Gradle.
    *   To build from the command line, run `./gradlew assembleDebug` in the root directory of the project.

## Key Components

*   **`MainActivity.kt`:** The main entry point of the application. This file contains the main UI of the app and handles the permission request flow for push notifications.
*   **`MessagingService.kt`:** This service is responsible for handling incoming push notifications from FCM.
*   **`RequestNotificationPermit.kt`:** This composable function displays a dialog to the user, explaining why the push notification permission is required and prompting them to grant it.

## Dependencies

This project uses the following key dependencies:

*   [Firebase Cloud Messaging](https://firebase.google.com/docs/cloud-messaging)
*   [Jetpack Compose](https://developer.android.com/jetpack/compose)

