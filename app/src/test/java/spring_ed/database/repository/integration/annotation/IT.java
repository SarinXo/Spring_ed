package spring_ed.database.repository.integration.annotation;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import spring_ed.database.repository.integration.ApplicationTestRunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Integration Test annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//указываем в качестве запускаемого классв не ApplicationRunner помеченный аннотацией SpringBootApplication
// а наш тестовый класс
@SpringBootTest(classes = ApplicationTestRunner.class)
@ActiveProfiles("test")
public @interface IT {//Integration Test
}
