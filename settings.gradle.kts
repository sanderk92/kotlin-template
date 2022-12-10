rootProject.name = "project"
include("core")
include("integration-test")

pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
    }
}
