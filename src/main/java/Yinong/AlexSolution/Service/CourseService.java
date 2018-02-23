package Yinong.AlexSolution.Service;

import Yinong.AlexSolution.Model.Courses;
import Yinong.AlexSolution.Model.PreRequisite;

import java.util.Optional;

public interface CourseService {
    Optional<PreRequisite> findByCourses(Courses courses);
}
