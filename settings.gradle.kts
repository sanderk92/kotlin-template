rootProject.name = "project"
include("project")
include("integration-test")

pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
    }
}
