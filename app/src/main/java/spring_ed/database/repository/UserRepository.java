package spring_ed.database.repository;

import spring_ed.database.pool.ConnectionPool;
public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
