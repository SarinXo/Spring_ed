package spring_ed.database.repository.integration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import spring_ed.database.pool.ConnectionPool;

@TestConfiguration
public class TestApplicationRunner {
    //выносим Spy bean для того чтобы контекст не создавался заново
    // спайбин меняет
    @SpyBean(name = "id_is_pool1")
    ConnectionPool id_is_pool1;
}
