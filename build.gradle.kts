import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	// Kotlin
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"

	// Spring
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"

	// Static code analysis
	id("io.gitlab.arturbosch.detekt") version "1.8.0"
	id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	jcenter() // Required for Detekt
	mavenCentral()
}

dependencies {
	// Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// Spring
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	// Logging
	implementation("io.github.microutils:kotlin-logging:2.1.23")

	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

ktlint {
	additionalEditorconfigFile.set(File("./config/ktlint/.editorconfig"))
}
