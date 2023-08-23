package spring_ed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

//если entity для таблиц лежат вне Application runner, который сканирует
//все пакеты, то можно указать дополнительный путь до папки с entity которые
//нужно просканировать с помощью
//@EntityScan
//все классы которые относятся к этому раннеру должны находиться с ним в одном пакете
@SpringBootApplication
//сканирует все пакеты которые лежат в одной папке с этим классом
// и получает ConfigurationProperties
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
       var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(context.getBeanDefinitionCount() + " - beans active");
    }
}