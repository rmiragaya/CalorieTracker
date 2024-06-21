plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android{
    namespace = "com.rmiragaya.coreui"
}

dependencies {
    // can import dependencies for just this module
}