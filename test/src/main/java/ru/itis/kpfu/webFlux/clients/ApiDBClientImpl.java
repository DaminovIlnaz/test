package ru.itis.kpfu.webFlux.clients;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.kpfu.webFlux.entries.Comment;
import ru.itis.kpfu.webFlux.entries.DBRecord;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Component
public class ApiDBClientImpl implements ApiClient {

    private ConnectionFactory connectionFactory;

    public ApiDBClientImpl() {
        ConnectionFactoryOptions options = builder()
                .option(DRIVER, "postgresql")
                .option(PORT, 5432)
                .option(HOST, "localhost")
                .option(USER, "postgres")
                .option(PASSWORD, "12345")
                .option(DATABASE, "test")
                .build();
        this.connectionFactory = ConnectionFactories.get(options);
    }

    @Override
    public Flux<Comment> getAll() {
        DatabaseClient client = DatabaseClient.create(connectionFactory);
        return client.execute("select * from \"user\"").as(DBRecord.class).fetch().all()
                .map(row -> Comment.builder()
                        .userId(row.getUserId())
                        .id(row.getId())
                        .title(row.getTitle())
                        .body(row.getBody())
                        .from("DataBase")
                        .build()
                );
    }

}
