package Yinong.AlexSolution.Repository;

import Yinong.AlexSolution.Model.PreRequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreRequisiteRepository extends JpaRepository<PreRequisite,Long>{
    @Query("select u from User u")
    List<PreRequisite> findByCourseName(String courseName);
}
