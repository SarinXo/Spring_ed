package spring_ed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//все классы которые относятся к этому раннеру должны находиться с ним в одном пакете
@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {
       var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(context.getBeanDefinitionCount());
    }
}
