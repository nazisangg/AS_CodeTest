package Yinong.AlexSolution.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreRequisite extends JpaRepository<PreRequisite,Long>{
    //TODO think about the sql santance of this query
    @Query("")
    List<PreRequisite> findByCourseName(String courseName);
}
