package spring_ed.database.pool;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component("id_is_pool1")
@RequiredArgsConstructor
public class ConnectionPool {
    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;
//    private final List<Object> args;
//    private final Map<String, Object> properties;

    @PostConstruct
    private void init() {
        log.info("Init connection pool");
    }


    @PreDestroy
    private void destroy() {
        log.info("Clean connection pool");
    }
}
