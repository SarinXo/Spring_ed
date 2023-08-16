package spring_ed.database.repository.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import spring_ed.database.pool.ConnectionPool;
import spring_ed.database.repository.integration.annotation.IT;
import spring_ed.service.UserService;

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final UserService userService;
    //Application context не создается заново только в том случае, если
    //application context не изменяется
    //
    //@SpyBean(name = "pool1")
    private final ConnectionPool id_is_pool1;

    @Test
    void test(){

    }
}
