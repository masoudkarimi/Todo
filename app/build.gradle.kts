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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {
    implementation(project(":base:ui"))
    implementation(project(":base:android"))
    implementation(project(":data:db"))
    implementation(project(":data:room_db"))
    implementation(project(":feature:tasks:data"))
    implementation(project(":feature:tasks:domain"))
    implementation(project(":feature:tasks:ui"))

    implementation(libs.hilt.navigation.compose)
    implementation(libs.compose.navigation)
    implementation(libs.hilt)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.ktx)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)
    implementation(libs.hilt)

    // Android Studio Preview support
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.tooling)

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