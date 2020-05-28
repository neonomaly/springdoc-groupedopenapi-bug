package org.springdoc.openapibug.api.v2

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v2")
class SampleControllerV2 {

    @GetMapping
    suspend fun get() = "Sample V2"

}