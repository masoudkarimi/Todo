plugins {
    id("kotlin")
    alias(libs.plugins.kotlin.kapt)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(libs.coroutine.core)
    implementation(libs.dagger)

    kapt(libs.dagger.compiler)

}