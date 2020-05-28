package org.springdoc.openapibug

import io.swagger.v3.oas.annotations.Operation
import org.springdoc.core.GroupedOpenApi
import org.springdoc.core.SpringDocConfigProperties
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/\${springdoc.api-docs.path:/v3/api-docs}")
class OpenApiController(_apis: List<GroupedOpenApi>,
                        config: SpringDocConfigProperties) {

    val apis = _apis.map {
        ApiInfo(
                group = it.group,
                url = "/${config.apiDocs.path}/${it.group}"
        )
    }

    data class ApiInfo(val group: String, val url: String)

    @Operation(hidden = true)
    @GetMapping
    fun groupInfo(): Any = if (apis.size == 1) {
        ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
                .header(HttpHeaders.LOCATION, apis.first().url)
                .build<Unit>()
    } else {
        apis
    }

}