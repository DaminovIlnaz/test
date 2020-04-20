package ru.itis.kpfu.webFlux.entries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DBRecord {
    private Long userId;
    private Long id;
    private String title;
    private String body;
    private String from;
}