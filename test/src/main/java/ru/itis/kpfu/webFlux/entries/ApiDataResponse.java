package ru.itis.kpfu.webFlux.entries;

import lombok.Data;
import java.util.List;

@Data
public class ApiDataResponse {
    private List<ApiDataRecord> data;
}