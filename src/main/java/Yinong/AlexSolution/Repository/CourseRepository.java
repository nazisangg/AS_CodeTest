package Yinong.AlexSolution.Repository;

import Yinong.AlexSolution.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses,Long>{
    Courses findById (Long id);

    Courses findByCourseName(String courseName);

}
