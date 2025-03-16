# animal_tech_task

Kotlin using MVVM architecture, Retrofit, Glide, and RecyclerView.

Technologies Used
Kotlin (Android programming language)
MVVM Architecture (Model-View-ViewModel)
Retrofit (for API calls)
Glide (for image caching)
RecyclerView (for displaying employee list)
ViewBinding (for cleaner UI code)
Coroutines (for asynchronous tasks)

Make sure your build.gradle (Module: app) has the following dependencies:
 // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.1")

    // refresh layout
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    //view Model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.8.7")

    // Coroutines (important for ViewModel)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")


    // Glide dependency for image loading and caching
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

    //get viewModel by viewModels? (fragment-ktx)
    implementation ("androidx.fragment:fragment-ktx:1.1.0")
    implementation ("androidx.activity:activity-ktx:1.3.1")

1. Create the Data Model (Employee.kt)
 2. Create Retrofit API Interface (EmployeeApi.kt)
3. Retrofit API Client (ApiClient.kt)
4. Repository for Data Fetching (EmployeeRepository.kt)
5. ViewModel (MainViewModel.kt)
 6. RecyclerView Adapter (EmployeeAdapter.kt)
7. Main Activity (MainActivity.kt)
8. XML Layouts
activity_main.xml
item_employee.xml -- RecyclerView Items View


📂 EmployeeDirectoryApp
 ├── 📂 api
 │   ├── EmployeeApi.kt
 │   ├── ApiClient.kt
 ├── 📂 model
 │   ├── Employee.kt
 ├── 📂 repository
 │   ├── EmployeeRepository.kt
 ├── 📂 ui
 │   ├── EmployeeAdapter.kt
 │   ├── MainActivity.kt
 │   ├── MainViewModel.kt
 ├── 📂 utils
 │   ├── Resource.kt
 ├── 📜 AndroidManifest.xml
 ├── 📜 activity_main.xml
 ├── 📜 item_employee.xml



Features in MainActivity.kt
Fetches employee data from the API using ViewModel
Displays loading spinner while fetching data
Handles errors gracefully (shows Toast message for API errors)
Shows an empty state message when there are no employees
Implements Swipe-to-Refresh for reloading the employee list
Uses ViewBinding for cleaner UI handling

Output & Behavior
 App starts → Shows loading spinner
Data loads successfully → Displays list of employees
If data is empty → Displays "No Employees Available" message
If error occurs → Shows a Toast message
Swipe down to refresh → Reloads employee list

 Enable ViewBinding in build.gradle
Make sure ViewBinding is enabled in your build.gradle (Module: app) file.

android {
    viewBinding {
        enabled = true
    }
}


This app fetches employee data, caches images, handles errors, and refreshes the list efficiently!
