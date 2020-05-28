package org.springdoc.openapibug.api.v2

import org.springdoc.openapibug.api.defineOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiDescriptorV2 {

    @Bean
    fun sampleApiV2() = defineOpenApi(
            group = "sample-v2",
            version = "2",
            packageName = OpenApiDescriptorV2::class.java.`package`.name,
            title = "Sample API"
    )

}
