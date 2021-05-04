import org.jetbrains.compose.compose

plugins {
    id("kotlin-library-conventions")
    id("org.jetbrains.compose")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven {
        setUrl("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencies {
    implementation(compose.runtime)
}

