package spring_ed.database.pool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("id_is_pool1")
public class ConnectionPool {

    private final String username;
    private final Integer poolSize;
//    private final List<Object> args;
//    private final Map<String, Object> properties;

    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;

    }

    @PostConstruct
    private void init() {
        System.out.println("Init connection pool");
    }


    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool");
    }
}
