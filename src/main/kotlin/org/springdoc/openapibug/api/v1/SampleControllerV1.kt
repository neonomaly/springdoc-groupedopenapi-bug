package org.springdoc.openapibug.api.v1

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Schema(name = "Global")
data class Global<T> (

    @Schema(description = "Name")
    val name: String,

    @Schema(description = "Details", oneOf = [

    ])
    val details: T
)

@Schema(name = "OneDetails")
data class One (
        @Schema(description = "One")
        val one: String
)

@Schema(name = "TwoDetails")
data class Two (
        @Schema(description = "Two")
        val two: String
)



@RestController
@RequestMapping("/v1")
class SampleControllerV1 {

    @GetMapping
    suspend fun get(): Global<*> = Global(name = "Some", details = One(one = "one"))

}