package spring_ed.database.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import spring_ed.database.pool.ConnectionPool;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    @Qualifier("id_is_pool1")
    private final ConnectionPool connectionPool;

}
