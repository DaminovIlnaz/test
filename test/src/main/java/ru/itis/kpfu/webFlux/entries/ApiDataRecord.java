package ru.itis.kpfu.webFlux.entries;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiDataRecord {
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
}