pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven {
            setUrl("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        }
    }
}
rootProject.name = "compositree"
include("app")
