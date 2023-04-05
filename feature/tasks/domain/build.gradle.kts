@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("kotlin")
    alias(libs.plugins.kotlin.kapt)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(libs.coroutine.core)
    implementation(libs.dagger)

    kapt(libs.dagger.compiler)

}