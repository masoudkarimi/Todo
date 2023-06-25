import java.util.Properties
import java.io.FileInputStream

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

val useReleaseKeystore = rootProject.file("keys/app-release.jks").exists()

android {
    namespace = "mkn.todo"


    defaultConfig {
        applicationId = "mkn.todo"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            storeFile = rootProject.file("keys/app-debug.jks")
            storePassword = "123456"
            keyAlias = "todo-debug-alias"
            keyPassword = "123456"
        }

        create("release") {
            if (useReleaseKeystore) {
                val keystorePropertiesFile = rootProject.file("keystore.properties")
                val keystoreProperties = Properties()
                keystoreProperties.load(FileInputStream(keystorePropertiesFile))
                keyAlias = keystoreProperties["keyAlias"].toString()
                keyPassword = keystoreProperties["keyPassword"].toString()
                storeFile = rootProject.file(keystoreProperties["storeFile"].toString())
                storePassword = keystoreProperties["storePassword"].toString()
            }
        }
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs["debug"]
            isMinifyEnabled = false
        }

        getByName("release") {
            signingConfig = signingConfigs[if (useReleaseKeystore) "release" else "debug"]
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
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
    // Tasks feature
    implementation(project(":feature:tasks:data"))
    implementation(project(":feature:tasks:domain"))
    implementation(project(":feature:tasks:ui"))

    // Profile feature
    implementation(project(":feature:profile:data"))
    implementation(project(":feature:profile:domain"))
    implementation(project(":feature:profile:ui"))

    // Add new task feature
    implementation(project(":feature:addtask:data"))
    implementation(project(":feature:addtask:domain"))
    implementation(project(":feature:addtask:ui"))

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