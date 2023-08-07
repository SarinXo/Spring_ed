package spring_ed.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import spring_ed.config.condition.JpaCondition;

import javax.annotation.PostConstruct;

//создавай, если выполнено условие в этом классе
//т.к. в нем будет переопределен метод matches от
//функционального интерфейса
@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    void init(){
        System.out.println("JpaConfiguration is enabled");
    }

    //теперь нужно создать бин от нашей концигурации бд

    @Bean
    @ConfigurationProperties(prefix = "db")
    public YamlDatabaseConfigProperties databaseProperties(){
        return new YamlDatabaseConfigProperties();
    }
}
