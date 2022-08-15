import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"

    kotlin("plugin.spring") version "1.6.21" apply false
    id("org.springframework.boot") version "2.7.2" apply false
    id("io.spring.dependency-management") version "1.0.12.RELEASE" apply false
}

repositories {
    jcenter()
    mavenCentral()
}

group = "com.project"
version = "1.0-SNAPSHOT"

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "io.gitlab.arturbosch.detekt")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

        implementation("io.github.microutils:kotlin-logging:2.1.23")

        testImplementation("com.github.tomakehurst:wiremock:2.27.2")
    }

    detekt {
        // Configured in 'config/detekt/detekt.yml'
        allRules = true
    }

    ktlint {
        // Configured in '.editorconfig'
        enableExperimentalRules.set(true)
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}
