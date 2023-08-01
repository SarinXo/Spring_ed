package spring_ed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import spring_ed.database.pool.ConnectionPool;
import spring_ed.database.repository.CrudRepository;
import spring_ed.database.repository.UserRepository;
import web.config.WebConfig;

import static org.springframework.context.annotation.FilterType.ANNOTATION;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
import static org.springframework.context.annotation.FilterType.REGEX;

//комбинация всех 3-х вариантов определения bean definitions
//можем подключать их через эту аннотацию
@ImportResource("classpath:application.xml")
//другие Configuration classes
@Import(WebConfig.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "spring_ed",
               useDefaultFilters = false,
               scopedProxy = ScopedProxyMode.NO,
               includeFilters = {
                    @Filter(type = ANNOTATION, value = Component.class),
                    @Filter(type = ASSIGNABLE_TYPE, value = CrudRepository.class),
                    @Filter(type = REGEX, pattern = "com\\..+Repository")
               }
)
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool connectionPool2(@Value("${db.username}") String username ){
        return new ConnectionPool(username, 20);
    }

    @Bean
    public UserRepository userRepository(ConnectionPool connectionPool2){
        return new UserRepository(connectionPool2);
    }
}
