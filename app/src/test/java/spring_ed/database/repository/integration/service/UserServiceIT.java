package spring_ed.database.repository.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import spring_ed.database.pool.ConnectionPool;
import spring_ed.database.repository.integration.annotation.IT;
import spring_ed.service.UserService;

@IT
@RequiredArgsConstructor
// для того чтобы контекст становился грязным и мы не могли его переиспользовать
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIT {

    private final UserService userService;
    //Application context не создается заново только в том случае, если
    //application context не изменяется
    //
    //@SpyBean(name = "pool1")
    private final ConnectionPool id_is_pool1;

    @Test
    //только для методов и на этом изменения все
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    void test(){
        System.out.println("test1");
    }
    @Test
    void test2(){
        System.out.println("test2");
    }
}
