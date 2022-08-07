package com.project.config

import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun api(): GroupedOpenApi = GroupedOpenApi.builder()
        .group("Project")
        .pathsToMatch("/**")
        .build()
}
