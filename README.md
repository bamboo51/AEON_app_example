# Aeon Shopping App
**This app is for demonstration only. AEON corporation just only sponsored in a hackathon and this app is for that hackathon only.**

**This project is deprecated from Kotlin Gradle Support**

This repository contains the source code for the Aeon Shopping app developed using Kotlin and Android Studio. The app allows users to explore products, scan barcodes, and manage their shopping activities.

## Features

### 1. Main Activity

The `MainActivity` is the entry point of the application. It sets up the user interface and provides a button for users to log in. Upon clicking the "Login" button, the app navigates to the `Nav_Control` activity.

```kotlin
// MainActivity
class MainActivity : AppCompatActivity() {
    // ...
}
```

### 2. Food Content Activity

The `Food_Content` activity displays detailed information about a food product. Users can add the product to their cart, and a Snackbar notification is shown upon successful addition. Additionally, users can navigate back to the scanner.

```kotlin
// Food_Content
class Food_Content : AppCompatActivity() {
    // ...
}
```

### 3. Navigation Control Activity

The `Nav_Control` activity manages the bottom navigation bar, allowing users to switch between different fragments, such as Home, Cart, Account, and Settings. It also provides a barcode scanning feature.

```kotlin
// Nav_Control
class Nav_Control : AppCompatActivity() {
    // ...
}
```

### 4. Scanner Activity

The `Scanner` activity integrates barcode scanning functionality using the `CodeScanner` library. Users can scan barcodes, view the scanned text, and navigate to the detailed information about the scanned product.

```kotlin
// Scanner
class Scanner : AppCompatActivity() {
    // ...
}
```

## Usage

Clone the repository and open the project in Android Studio. Build and run the app on an Android emulator or a physical device. Ensure that the necessary permissions, particularly the camera permission, are granted for barcode scanning.

## Dependencies

The app uses the following external libraries:

- `com.google.android.material:material:1.4.0`
- `com.budiyev.android:codescanner:2.1.0`

Make sure to include these dependencies in your project.

## Contributing

Feel free to contribute to the development of this project by opening issues, providing feedback, or submitting pull requests.

## License

This project is licensed under the [MIT License](LICENSE).
