package spring_ed.database.repository;

import org.springframework.data.repository.Repository;
import spring_ed.database.entity.Company;

import java.util.Optional;

public interface CompanyRepository extends Repository<Company, Integer> {


    //имя ConnectionPool - влияет. С самого начала @Autowired захочет инициализировать
    // с таким же названием, как и название переменной
    // Так же можно использовать аннотацию @Qualifier("bean_name_or_alias")
    // с конструктором такая же тема - переданный аргумент должен называться так же как и бин
    // который инжектим
    //@Qualifier("id_is_pool1")
    //private final ConnectionPool pool;

    //спокойно инжектит в коллекцию все существующие бины данного класса
    //порядком следования можно управлять через аннотацию @Ordered
    //private final List<ConnectionPool> pools;

    // для inject'а поля или свойства в виде зависимости, то можем использовать
    // @Value - внутри нее используем EL или SpEL
    //@Value("${db.pool.size}")
    //private final int poolSize;

    //@PostConstruct
    //private void init() {
    //    log.info("init company repository");
    //}


    Optional<Company> findById(Integer id);

    void delete(Company entity);
}
