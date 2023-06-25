@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("kotlin")
}

dependencies {
    api(project(":data:model"))
    implementation(libs.coroutine.core)
    implementation(libs.java.inject)
}