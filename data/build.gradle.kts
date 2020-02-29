plugins {
    id("java-library")
    id("kotlin")
    kotlin("jvm")
    kotlin("plugin.serialization") version Version.Kotlin
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Library.Kotlin)
    implementation(Library.KotlinSerialization)
}
