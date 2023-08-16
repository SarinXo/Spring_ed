package spring_ed.database.repository.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestConstructor;
import spring_ed.config.condition.RecordYamlDbProperties;
import spring_ed.database.repository.annotation.IT;
import spring_ed.dto.CompanyReadDto;
import spring_ed.service.CompanyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT//MY OWN ANNOTATION
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)// Мы можем цеплять бины из приложения Spring
//@ActiveProfiles("test") //step 2
//@SpringBootTest         //step 2
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//        initializers = ConfigDataApplicationContextInitializer.class)
public class CompanyServiceIT {

    private static final int COMPANY_ID = 1;

    private final RecordYamlDbProperties recordYamlDbProperties;
    private final CompanyService companyService;
    @Test
    void findById(){
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }
}
