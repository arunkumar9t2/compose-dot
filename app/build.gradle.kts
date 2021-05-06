plugins {
  id("kotlin-application-conventions")
}

application {
  mainClass.set("dev.arunkumar.compositree.app.AppKt")
}

dependencies {
  implementation(project(":compose-dot"))
  implementation("guru.nidi:graphviz-java:0.18.1")
}
