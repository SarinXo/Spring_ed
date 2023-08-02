package spring_ed;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_ed.config.ApplicationConfiguration;
import spring_ed.database.pool.ConnectionPool;
import spring_ed.database.repository.CompanyRepository;
import spring_ed.database.repository.CrudRepository;
import spring_ed.service.CompanyService;

import java.io.Serializable;

public class ApplicationRunner {

    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

//        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
        //тол
        try (var context = new AnnotationConfigApplicationContext()) {
                context.register(ApplicationConfiguration.class);
                // ENVIROMENT -содержит все зависимости и контексты, но лучше не использовать т.к.
                // это внутренняя кухня, а эти профили можно и через файл application.yaml/properties
                // задать, но так тоже +- ок, а для других значений есть аннотация @Value($/#{})
                // можно установить профиль или получить
                context.getEnvironment().getActiveProfiles();
                context.refresh();//Запускает жизненный цикл бинов, но используется только 1 раз
                                  //последующие вызовы будут бесполезны
                var connectionPool = context.getBean("id_is_pool1", ConnectionPool.class);
                System.out.println(connectionPool);

                var companyService = context.getBean(CompanyService.class);
                System.out.println(companyService.findById(1));

        }
    }
}
