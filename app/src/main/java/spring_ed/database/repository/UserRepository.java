package spring_ed.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring_ed.database.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u " +
            "where " +
            "u.firstname like :firstname and " +
            "u.lastname like :lastname")
    List<User> findAll(String firstname, String lastname);

}
