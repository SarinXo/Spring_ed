package spring_ed.database.repository.integration;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import spring_ed.database.entity.Company;
import spring_ed.database.repository.integration.annotation.IT;

import javax.persistence.EntityManager;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@Transactional
//после выполнения теста
//@Rollback по умолчанию
//@Commit теперь тест save() будет фейлится, потому что уже есть Mail в DB
class CompanyRepositoryTest {

    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    @Test
    void findById(){
        transactionTemplate.executeWithoutResult(tx -> {
            var company = entityManager.find(Company.class, 1);
            assertNotNull(company);
            assertThat(company.getLocations()).hasSize(2);
            //если тут может быть исключение, которое не проверяется в
            //TransactionTemplate -> execute (то его нужно обрабатывать отдельно)
            // Это может быть бизнесс исключение (но так не красиво и лучше наследовать исключение от Runtime)
        });
    }

    @Test
    void save(){
        var company = Company.builder()
                .name("Mail")
                .locations(Map.of("ru", "Почта",
                                  "en", "Mail")
                )
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}