plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android{
    namespace = "com.rmiragaya.core"
}

dependencies {
    // can import dependencies for just this module
}