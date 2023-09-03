package spring_ed.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import spring_ed.database.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {


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

    // Эти операции уже есть в CrudRepository
    //
    //Optional<Company> findById(Integer id);
    //
    //void delete(Company entity);

    //Optional, Entity, Future(java.util.concurrent), Projection
    Optional<Company> findCompanyByName(@Param("name2") String name);

    //Collection, Stream (получаем не все сразу записи, а в зависимости от batch size)
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
