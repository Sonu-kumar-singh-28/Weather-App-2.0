# Xyvento: Global Weather App 2.0 🌤️

Welcome to the repository for **Xyvento**, a modern Android application crafted for providing instant, accurate global weather and ocean conditions. Designed by **Code-Quest-Studio**, Xyvento helps users plan trips and stay informed with essential atmospheric data.

---

## ✨ Key Features

Xyvento delivers a seamless and intuitive experience for accessing critical weather information:

* **Real-time Local & Global Weather:** Displays the current temperature and atmospheric conditions for any searched city worldwide.
    * *Screenshot Reference: `main_screen.jpg`, `main_screen2.jpg`*
* **Comprehensive Weather Metrics:** Provides essential data points in a clean, card-based layout:
    * Humidity
    * Wind Speed
    * Cloud and Rain Conditions
    * Min/Max Daily Temperatures
    * Sunrise and Sunset Times (Unix timestamps)
    * Sea Level Pressure (hPa)
* **Intuitive City Search:** Features a clear search bar for finding weather data by city name.
* **Full User Authentication:** Includes a secure and complete account management system:
    * **Registration:** Create an account using full name, email, and password. (*Screenshot: `register_user_design.jpg`*)
    * **Login:** Secure login access. (*Screenshot: `WhatsApp Image 2025-09-10 at 03.09.30_88faddf7.jpg`*)
    * **Password Reset:** Dedicated screen for email-based password recovery. (*Screenshot: `forget_passeord_design.jpg`*)
* **Onboarding Experience:** A welcoming start page explaining the app's purpose. (*Screenshot: `startu[_page.jpg`*)

---

## 🛠️ Technology Stack

This application utilizes robust technologies for both the mobile frontend and data retrieval:

| Component | Technology | Role |
| :--- | :--- | :--- |
| **Frontend (Mobile)** | **Android (Kotlin)** | Building the native Android UI and application logic. |
| **Data Source** | **OpenWeatherMap API** or equivalent | Fetching accurate, real-time meteorological data. |
| **Authentication** | **Firebase Auth** or custom backend | Managing user accounts, registration, and login state. |
| **Branding** | **Code-Quest-Studio** | Application co-powering and development. |

---

## 🚀 Getting Started

Follow these steps to clone and run the Xyvento application on your local machine.

### Prerequisites

* **Java Development Kit (JDK):** Version 11 or higher.
* **Android Studio:** Required for building and running the Android project.
* **Git:** For cloning the repository.
* **Gradle:** Used for dependency management and project builds.

### Installation & Setup

1.  **Clone the repository:**

    ```bash
    git clone [https://github.com/Sonu-Kumar-Singh-28/Weather-App-2.0.git](https://github.com/Sonu-Kumar-Singh-28/Weather-App-2.0.git) 
    cd Xyvento-Weather-App
    ```

2.  **API Key Configuration:**
    * Obtain a **Weather API Key** (e.g., from OpenWeatherMap).
    * Insert this key into your project's configuration file (e.g., a constants file or `local.properties`).

3.  **Firebase Setup (If Applicable):**
    * Set up a Firebase project for authentication.
    * Place your **`google-services.json`** file into the `app/` directory of the Android project.

4.  **Run the Android App:**
    * Open the project in **Android Studio**.
    * Sync Gradle dependencies.
    * Select an AVD (emulator) or connect a physical device.
    * Click the **Run** button to build and launch the application.

---

## 🤝 Contributing

We welcome contributions to make Xyvento even more powerful!

1.  Fork the Project.
2.  Create your Feature Branch (`git checkout -b feature/hourly-forecast`).
3.  Commit your Changes (`git commit -m 'feat: Added hourly forecast view'`).
4.  Push to the Branch (`git push origin feature/hourly-forecast`).
5.  Open a Pull Request.

---

## 📧 Contact

**Sonu Kumar Singh**
* **Email:** sonusinghsengar28@gmail.com
* **Project Link:** [https://github.com/Sonu-Kumar-Singh-28/Weather-App-2.0](https://github.com/Sonu-Kumar-Singh-28/Weather-App-2.0)
