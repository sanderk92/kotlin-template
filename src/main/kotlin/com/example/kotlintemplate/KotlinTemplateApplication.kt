package com.example.kotlintemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinTemplateApplication

@SuppressWarnings("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<KotlinTemplateApplication>(*args)
}
