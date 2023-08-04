package spring_ed.database.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spring_ed.database.pool.ConnectionPool;

@Repository
public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(@Qualifier("id_is_pool1") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
