package ru.itis.kpfu.webFlux.clients;

import reactor.core.publisher.Flux;
import ru.itis.kpfu.webFlux.entries.Comment;

public interface ApiClient {
    Flux<Comment> getAll();
}
