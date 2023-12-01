@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.globant.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "com.globant.data.HiltTestRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("Boolean", "IS_DEBUG", "true")
            buildConfigField(
                "String",
                "API_KEY",
                "\"Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzOWUwNWZhMzU0NjVmZTZhNzMwMzhlZWY4YmU4ODkxMSIsInN1YiI6IjY1NGU3YmRjMjg2NmZhMTA4ZTA4MTMyNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.OOksfoBsNEDFyQ8VyxpHoJhjEc8dV5wBsXfXhXGGVy4\"",
            )
        }
        release {
            buildConfigField("Boolean", "IS_DEBUG", "false")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.retrofit.interceptor.logging)

    implementation(libs.room)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.compiler)

    testImplementation(libs.androidx.runner)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.truth)
}
