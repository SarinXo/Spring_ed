package spring_ed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_ed.database.entity.Company;
import spring_ed.database.repository.CrudRepository;
import spring_ed.database.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

}
