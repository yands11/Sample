plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Library.Kotlin)
    implementation(Library.OkHttp)
    implementation(Library.Retrofit)
    implementation(Library.LoggingInterceptor)
    implementation(Library.GsonConverter)
}
