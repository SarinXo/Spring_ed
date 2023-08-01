package spring_ed;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_ed.config.ApplicationConfiguration;
import spring_ed.database.pool.ConnectionPool;
import spring_ed.database.repository.CrudRepository;

import java.io.Serializable;

public class ApplicationRunner {

    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

//        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
                //      clazz -> String -> Map<String, Object>
                System.out.println("holly");
                var connectionPool = context.getBean("id_is_pool1", ConnectionPool.class);
                System.out.println(connectionPool);

                var companyRepository = context.getBean("companyRepository", CrudRepository.class);
                System.out.println(companyRepository.findById(1));

        }
    }
}
