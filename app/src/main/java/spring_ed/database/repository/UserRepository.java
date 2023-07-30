package spring_ed.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring_ed.database.pool.ConnectionPool;

@Repository
public class UserRepository {

    private final ConnectionPool connectionPool;

    @Autowired
    public UserRepository(ConnectionPool pool1) {
        this.connectionPool = pool1;
    }
}
