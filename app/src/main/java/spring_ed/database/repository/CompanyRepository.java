package spring_ed.database.repository;


import spring_ed.bean_post_processor.Auditing;
import spring_ed.bean_post_processor.InjectBean;
import spring_ed.bean_post_processor.Transaction;
import spring_ed.database.entity.Company;
import spring_ed.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}
