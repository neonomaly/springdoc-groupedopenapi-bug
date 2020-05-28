package org.springdoc.openapibug

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpenApiBugApplication

fun main(args: Array<String>) {
    runApplication<OpenApiBugApplication>(*args)
}
