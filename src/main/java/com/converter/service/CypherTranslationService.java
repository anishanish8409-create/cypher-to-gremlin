package com.converter.service;

import lombok.extern.slf4j.Slf4j;
import org.opencypher.gremlin.translation.CypherAst;
import org.opencypher.gremlin.translation.groovy.GroovyPredicate;
import org.opencypher.gremlin.translation.translator.Translator;
import org.opencypher.gremlin.translation.translator.TranslatorFlavor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CypherTranslationService {

    public Mono<String> translate(String cypherQuery) {
        return Mono.fromCallable(() -> {
            CypherAst ast = CypherAst.parse(cypherQuery);
            Translator<String, GroovyPredicate> translator = Translator.builder()
                    .gremlinGroovy()
                    .build(TranslatorFlavor.gremlinServer());
            return ast.buildTranslation(translator);
        });
    }
}
