plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(project(mapOf("path" to ":data")))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Library.Kotlin)
    implementation(Library.Retrofit)
}
