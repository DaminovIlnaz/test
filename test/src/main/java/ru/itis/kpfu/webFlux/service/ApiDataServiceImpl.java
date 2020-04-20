package ru.itis.kpfu.webFlux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.itis.kpfu.webFlux.clients.ApiClient;
import ru.itis.kpfu.webFlux.entries.Comment;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiDataServiceImpl implements ApiDataService {

    @Autowired
    private List<ApiClient> clients;

    @Override
    public Flux<Comment> getAll() {
        List<Flux<Comment>> fluxes =  clients.stream().map(this::getAll).collect(Collectors.toList());
        return Flux.merge(fluxes);
    }

    private Flux<Comment> getAll(ApiClient client) {
        return client.getAll().subscribeOn(Schedulers.elastic());
    }
}