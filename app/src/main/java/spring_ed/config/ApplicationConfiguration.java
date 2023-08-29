package spring_ed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import spring_ed.database.pool.ConnectionPool;
import spring_ed.database.repository.UserRepository;
import web.config.WebConfig;

//комбинация всех 3-х вариантов определения bean definitions
//можем подключать их через эту аннотацию
//@ImportResource("classpath:application.xml")
//другие Configuration classes
@Import(WebConfig.class)
@Configuration
//@PropertySource("classpath:application.yaml")
//Это есть @SpringBootApplication
//@ComponentScan(basePackages = "spring_ed",
//               useDefaultFilters = false,
//               scopedProxy = ScopedProxyMode.NO,
//               includeFilters = {
//                    @Filter(type = ANNOTATION, value = Component.class),
//                    @Filter(type = ASSIGNABLE_TYPE, value = CrudRepository.class),
//                    @Filter(type = REGEX, pattern = "com\\..+Repository")
//               }
//)
// теперь его заменяет @SpringBootApplication в которой уже есть ComponentScan
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool connectionPool2(@Value("${db.username}") String username ){
        return new ConnectionPool(username, 20);
    }
    @Bean
    public ConnectionPool connectionPool3(){
        return new ConnectionPool("username", 30);
    }

    @Bean
    public UserRepository userRepository1(ConnectionPool connectionPool2){
        return new UserRepository(connectionPool2);
    }

    // ! | &
    @Profile("web")
    @Bean
    public UserRepository userRepository2( ){
        var b1 = connectionPool3();
        var b2 = connectionPool3();
        return new UserRepository(connectionPool3());
    }
}
