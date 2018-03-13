package Yinong.AlexSolution.Repository;

import Yinong.AlexSolution.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor{

    User findById(Long id);

    User findByUsername(String username);

    @Query("select u from User u")
    List<User> findAllUsers();

}
