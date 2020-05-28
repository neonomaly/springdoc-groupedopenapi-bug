package org.springdoc.openapibug.api.v1

import org.springdoc.openapibug.api.defineOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApiDescriptorV1 {

    @Bean
    fun sampleApiV1() = defineOpenApi(
            group = "sample-v1",
            version = "1",
            packageName = OpenApiDescriptorV1::class.java.`package`.name,
            title = "Sample API"
    )

}
