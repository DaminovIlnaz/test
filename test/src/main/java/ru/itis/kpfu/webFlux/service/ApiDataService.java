package ru.itis.kpfu.webFlux.service;

import reactor.core.publisher.Flux;
import ru.itis.kpfu.webFlux.entries.Comment;

public interface ApiDataService {
    Flux<Comment> getAll();
}
