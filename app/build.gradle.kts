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
                "proguard-rules.pro"
            )
        }
    }
    dataBinding.isEnabled = true

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":domain", "configuration" to "default")))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Library.Kotlin)
    implementation(Library.AppCompat)
    implementation(Library.Core)
    implementation(Library.Constraint)
    implementation(Library.LiveData)
    implementation(Library.ViewModel)
    implementation(Library.Material)
    implementation(Library.Coil)
    implementation(Library.OkHttp)
    implementation(Library.Retrofit)
    implementation(Library.GsonConverter)
    implementation(Library.Timber)
    implementation(Library.Dagger)
    implementation(Library.DaggerAndroidSupport)
    kapt(Library.DaggerCompiler)
    kapt(Library.DaggerAndroidProcessor)
    testImplementation(Library.JUnit)
    androidTestImplementation(Library.JUnitExt)
    androidTestImplementation(Library.Espresso)
}
