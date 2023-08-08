package spring_ed.database.repository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring_ed.bean_post_processor.Auditing;
import spring_ed.bean_post_processor.InjectBean;
import spring_ed.bean_post_processor.Transaction;
import spring_ed.database.entity.Company;
import spring_ed.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Transaction
@Auditing
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company> {


    //имя ConnectionPool - влияет. С самого начала @Autowired захочет инициализировать
    // с таким же названием, как и название переменной
    // Так же можно использовать аннотацию @Qualifier("bean_name_or_alias")
    // с конструктором такая же тема - переданный аргумент должен называться так же как и бин
    // который инжектим
    @Qualifier("id_is_pool1")
    private final ConnectionPool pool;

    //спокойно инжектит в коллекцию все существующие бины данного класса
    //порядком следования можно управлять через аннотацию @Ordered
    private final List<ConnectionPool> pools;

    // для inject'а поля или свойства в виде зависимости, то можем использовать
    // @Value - внутри нее используем EL или SpEL
    @Value("${db.pool.size}")
    private final int poolSize;

    @PostConstruct
    private void init() {
        log.info("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        log.info("findById method...");
        return Optional.of(new Company(id));
    }
    @Override
    public void delete(Company entity) {
        log.info("delete method...");
    }
}
