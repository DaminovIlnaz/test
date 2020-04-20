package ru.itis.kpfu.webFlux.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.kpfu.webFlux.entries.ApiDataRecord;
import ru.itis.kpfu.webFlux.entries.Comment;

import java.util.Arrays;

@Component
public class ApiWebClientImpl implements ApiClient {

    private WebClient client;

    public ApiWebClientImpl(@Value("${comments.utl}") String url) {
        client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(100 * 1024 * 1024))
                        .build())
                .baseUrl(url)
                .build();
    }

    @Override
    public Flux<Comment> getAll() {
        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(ApiDataRecord[].class))
                .flatMapIterable(Arrays::asList)
                .map(record ->
                        Comment.builder()
                                .userId(record.getUserId())
                                .id(record.getId())
                                .title(record.getTitle())
                                .body(record.getBody())
                                .from("Web")
                                .build());
    }
}
