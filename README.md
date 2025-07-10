# Rick and Morty API with Kotlin Multiplatform

This is a test project to learn how to use Kotlin Multiplatform by creating a mobile application that consumes the Rick and
Morty API, following the course
from [Appcademy](https://www.appcademy.dev/kotlin-multiplataforma-compose-curso-definitivo-desde-0).

## Implemented Features

- ✅ Initial project structure
- ✅ Basic navigation system
- ✅ API services and data models for character retrieval
- ✅ Pagination support and UI integration
- ✅ Local database integration using SQLite with Room

## Technologies Used

- **Kotlin Multiplatform**: Framework for sharing code across platforms
- **Compose Multiplatform**: Declarative UI framework for multiple platforms
- **Rick & Morty API**: External data source for practicing network calls

## Read Local Database

To inspect the app's local database, follow these steps:

1. **Open the app in the Android emulator**  
   Make sure the application is installed and running in the emulator.

2. **Extract the database from the emulator**  
   Run the `pull-db-from-android-emulator.sh` script included in the project. This script will copy the following files from the emulator to your local machine:
   - `rm_app_database.db`
   - `rm_app_database.db-shm`
   - `rm_app_database.db-wal`

   > **Note:** If the script does not have execution permissions, use `chmod +x pull-db-from-android-emulator.sh` to enable them.

3. **Open the database with an SQLite viewer**  
   You can use your preferred tool to explore SQLite files. Recommended options:
   - **IntelliJ IDEA / Android Studio**:  
     - Go to the "Database" tab.
     - Click "+" and select "Data Source" > "SQLite".
     - Choose the extracted `rm_app_database.db` file.
   - **DB Browser for SQLite**:  
     - Open the application and select "Open Database".
     - Choose the `rm_app_database.db` file.

4. **Explore tables and data**  
   You can now inspect tables, run queries, and verify the data stored locally by the app.

> If you have trouble finding the database path in the emulator, check the script to ensure it points to the correct directory (`/data/data/<package_name>/databases/`).

## Learning Resources

- [Kotlin Multiplatform Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/)

## Feedback and Contributions

This is a personal learning project. If you find issues or have suggestions, please feel free to open an issue in
the [repository](https://github.com/AdriReche/kmp-rick-morty-app).

---

*Project based on the Kotlin Multiplatform course by Appcademy*