plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android{
    namespace = "com.rmiragaya.tracker_domain"
}

dependencies {
    // can import dependencies for just this module
    implementation(project(Modules.core))
}