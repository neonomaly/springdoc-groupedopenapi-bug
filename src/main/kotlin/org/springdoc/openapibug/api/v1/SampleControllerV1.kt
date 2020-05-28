package org.springdoc.openapibug.api.v1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class SampleControllerV1 {

    @GetMapping
    suspend fun get() = "Sample V1"

}