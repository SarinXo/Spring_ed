package spring_ed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_ed.database.repository.CompanyRepository;
import spring_ed.database.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

}
