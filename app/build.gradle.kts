@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "mkn.todo"
    compileSdk = 33

    defaultConfig {
        applicationId = "mkn.todo"
        minSdk = 22
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(project(":base:android"))
    implementation(project(":data:db"))
    implementation(project(":data:room_db"))
    implementation(project(":feature:tasks:data"))
    implementation(project(":feature:tasks:domain"))
    implementation(project(":feature:tasks:ui"))

    implementation(libs.hilt)
    implementation(libs.room.runtime)
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.uiktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)

    kapt(libs.hilt.compiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

// https://github.com/google/dagger/issues/2123
hilt {
    enableAggregatingTask = true
}