plugins {
    kotlin("jvm") version "1.7.10" apply false
    id("io.gitlab.arturbosch.detekt") version "1.8.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0" apply false
    id("org.jetbrains.dokka") version "1.4.20" apply false

    kotlin("plugin.spring") version "1.6.21" apply false
    id("org.springframework.boot") version "2.7.2" apply false
    id("io.spring.dependency-management") version "1.0.12.RELEASE" apply false
}

group = "com.project"
version = "1.0-SNAPSHOT"

subprojects {
    repositories {
        jcenter()
        mavenCentral()
    }
}
