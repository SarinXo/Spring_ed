package spring_ed.config;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import spring_ed.database.repository.CrudRepository;

import static org.springframework.context.annotation.FilterType.ANNOTATION;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
import static org.springframework.context.annotation.FilterType.REGEX;

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

}
