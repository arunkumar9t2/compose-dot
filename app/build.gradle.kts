plugins {
    id("kotlin-application-conventions")
}

application {
    mainClass.set("dev.arunkumar.compositree.app.AppKt")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
}
