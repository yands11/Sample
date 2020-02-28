buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(Plugin.Android)
        classpath(Plugin.Kotlin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}