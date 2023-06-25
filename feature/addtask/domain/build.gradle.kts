@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("kotlin")
    alias(libs.plugins.kotlin.kapt)
}

dependencies {
    api(project(":data:model"))
    implementation(libs.coroutine.core)
    implementation(libs.java.inject)
}