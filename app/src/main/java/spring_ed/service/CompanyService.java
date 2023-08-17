package spring_ed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import spring_ed.database.entity.Company;
import spring_ed.database.repository.CrudRepository;
import spring_ed.dto.CompanyReadDto;
import spring_ed.listener.entity.AccessType;
import spring_ed.listener.entity.Event;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                .map(entity -> {
                    applicationEventPublisher.publishEvent(new Event(entity, AccessType.READ));
                    //applicationEventPublisher.publishEvent(new Event(entity, AccessType.UPDATE));
                    return new CompanyReadDto(entity.getId());
                });
    }
}
