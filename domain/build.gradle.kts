plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Config.CompileSDK)
    buildToolsVersion = Version.AndroidBuildTools

    defaultConfig {
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

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Library.Kotlin)
    implementation(Library.AppCompat)
    implementation(Library.Core)
}
