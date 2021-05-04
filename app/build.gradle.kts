plugins {
    id("kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
}

application {
    mainClass.set("dev.arunkumar.compositree.app.AppKt")
}
