package ru.itis.kpfu.webFlux.entries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private Long userId;
    private Long id;
    private String title;
    private String body;
    private String from;
}
