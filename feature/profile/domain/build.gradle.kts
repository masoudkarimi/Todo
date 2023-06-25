@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("kotlin")
}

dependencies {
    implementation(libs.coroutine.core)
    implementation(libs.java.inject)
}