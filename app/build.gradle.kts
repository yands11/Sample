plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.CompileSDK)
    buildToolsVersion = Version.AndroidBuildTools

    defaultConfig {
        applicationId = Config.AppId
        targetSdkVersion(Config.TargetSDK)
        minSdkVersion(Config.MinSDK)
        versionCode = Config.VersionCode
        versionName = Config.VersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Library.Kotlin)
    implementation(Library.AppCompat)
    implementation(Library.Core)
    implementation(Library.Constraint)
    implementation(Library.ViewModel)
    testImplementation(Library.JUnit)
    androidTestImplementation(Library.JUnitExt)
    androidTestImplementation(Library.Espresso)
}
