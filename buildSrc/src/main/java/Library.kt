object Library {
    const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.Kotlin}"
    const val KotlinSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Version.KotlinSerialization}"

    const val AppCompat = "androidx.appcompat:appcompat:${Version.AppCompat}"
    const val Core = "androidx.core:core-ktx:${Version.Core}"
    const val Constraint = "androidx.constraintlayout:constraintlayout:${Version.Constraint}"
    const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Lifecycle}"

    const val OkHttp = "com.squareup.okhttp3:okhttp:${Version.OkHttp}"
    const val Retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"
    const val KotlinSerializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.KotlinSerializationConverter}"

    const val JUnit = "junit:junit:${Version.JUnit}"
    const val JUnitExt = "androidx.test.ext:junit:${Version.JUnitExt}"
    const val Espresso = "androidx.test.espresso:espresso-core:${Version.Espresso}"
}