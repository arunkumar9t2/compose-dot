pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven {
            setUrl("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        }
    }
}
rootProject.name = "compose-dot"

include("app")
include("dot")
include("compose-dot")
