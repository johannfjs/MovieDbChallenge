# Movie World (Jetpack Compose)

MovieDbChallenge app using [The Movie DB](https://www.themoviedb.org) built with jetpack Compose and MVVM architecture.<br>


<p float="left">
  <img width="30%" height="50%" src="https://github.com/johannfjs/MovieDbChallenge/blob/develop/screenshots/Screenshot_20231114_123233.png" />
  <img width="30%" height="50%" src="https://github.com/johannfjs/MovieDbChallenge/blob/develop/screenshots/Screenshot_20231114_123251.png" />
</p>

# Main Features
- List of popular people
- List of popular movies
- List of recommended movies
- List of top rated movies

## Architecture 🏗️
- MVVM Architecture
- Repository pattern
- Hilt - dependency injection

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) - A cold asynchronous data stream that sequentially emits values and completes normally or with an exception.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
- [Dependency Injection](https://developer.android.com/training/dependency-injection)
    - [Hilt](https://dagger.dev/hilt) - Easier way to incorporate Dagger DI into Android apps.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.

## Next steps location and gallery functionalities
For the location tab, I would first create in the firebase console the project in order to get the id to be used for consumption. Then, enable the services that I will need to consume.
With a Job in the background I can get the location in realtime and save it in the realtime database and in turn be able to consume it so that all locations are displayed.
With the push notification I can alert about the record that was added or I can read the database every x period of time.

For the gallery tab, request permission to read photos and camera to get the images and with the project created in firebase to enable the storage so you can upload the images and then proceed to make a consumption of the information that was uploaded to display it on the screen.

# License
```
Copyright 2023 johannfjs (Johann Jara Sánchez)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
