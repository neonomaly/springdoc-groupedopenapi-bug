package org.springdoc.openapibug.api

import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi

fun defineOpenApi(
        group: String,
        title: String,
        prefix: String = "",
        packageName: String? = null,
        version: String = "1",
        urlPrefix: String = "$prefix/v$version",
        description: String? = null
): GroupedOpenApi = GroupedOpenApi.builder()
        .setGroup(group)
        .pathsToMatch(prefix, "$prefix/**")
        .apply {
            if (packageName != null) packagesToScan(packageName)
        }
        .addOpenApiCustomiser { openApi ->
            openApi.info(
                    Info().title(title)
                            .version(version)
                            .description(description)
            )
                    .servers(listOf(Server().url(openApi.servers.first().url + urlPrefix)))
                    .paths.apply {

                        keys.toSet()
                                .filter { it.startsWith(urlPrefix) }
                                .forEach {
                                    put(it.removePrefix(urlPrefix), get(it))
                                    remove(it)
                                }

                    }
        }
        .build()