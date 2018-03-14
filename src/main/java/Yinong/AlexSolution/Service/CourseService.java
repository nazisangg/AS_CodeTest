package Yinong.AlexSolution.Service;

import Yinong.AlexSolution.Model.Courses;
import Yinong.AlexSolution.Model.PreRequisite;
import Yinong.AlexSolution.Model.User;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<List<PreRequisite>>  findByCourses(Courses courses);

    List<User> findAllUsers(Courses courses);

    void mapPreRequisiteToCourses();
}
