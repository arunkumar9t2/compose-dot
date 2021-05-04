plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven {
        setUrl("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
    implementation("org.jetbrains.compose:compose-gradle-plugin:0.3.1")
}
