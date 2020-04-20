package ru.itis.kpfu.webFlux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.kpfu.webFlux.entries.Comment;
import ru.itis.kpfu.webFlux.service.ApiDataService;

@RestController
public class ApiDataController {

    @Autowired
    private ApiDataService apiDataService;

    @RequestMapping(value = "/test",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            method = RequestMethod.GET)
    public Flux<Comment> getAll(){
        return apiDataService.getAll();
    }



}
