package com.converter.controller;

import com.converter.service.CypherTranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/translate")
@RequiredArgsConstructor
public class CypherController {

    private final CypherTranslationService translationService;

    @PostMapping
    public Mono<Map<String, String>> translateCypher(@RequestBody Mono<Map<String, String>> requestMono) {
        return requestMono
                .map(request -> request.get("cypher"))
                .flatMap(translationService::translate)
                .map(gremlinQuery -> Map.of("gremlin", gremlinQuery));
    }
}
