package Yinong.AlexSolution.Service;


import Yinong.AlexSolution.Model.Courses;
import Yinong.AlexSolution.Model.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);

    void addCourse(User user, Courses courses);

    List<User> findByExample(User example);

    List<User> findBySpecification(Specification<User> specification);

    User findUserByUsername(String username);
    //

}
