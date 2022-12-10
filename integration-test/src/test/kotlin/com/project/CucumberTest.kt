package com.project

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.project.CucumberTest.Companion.mongoContainer
import com.project.CucumberTest.Companion.wiremock
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import io.cucumber.spring.CucumberContextConfiguration
import mu.KotlinLogging
import org.junit.jupiter.api.AfterAll
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.utility.DockerImageName

private val log = KotlinLogging.logger {}

@ActiveProfiles("it")
@RunWith(Cucumber::class)
@CucumberOptions(
    plugin = ["pretty"],
    features = ["src/test/resources/features"],
    monochrome = true,
    tags = "@Integration"
)
@CucumberContextConfiguration
@SpringBootTest(classes = [Application::class])
class CucumberTest {

    companion object {

        val wiremock = WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort())

        @Container
        val mongoContainer = MongoDBContainer(DockerImageName.parse("mongo:6.0.3"))

        init {
            wiremock.start()
            mongoContainer.start()

            log.info { "Wiremock accessible on ${wiremock.baseUrl()}" }
            log.info { "MongoDB accessible on ${mongoContainer.connectionString}" }
        }

        @JvmStatic
        @DynamicPropertySource
        fun setProperties(registry: DynamicPropertyRegistry) {
            registry.add("wiremock.base-url") { wiremock.baseUrl() }
            registry.add("database.base-url", mongoContainer::getConnectionString)
        }
    }
}

@AfterAll
fun clean() {
    wiremock.stop()
    mongoContainer.stop()
}
