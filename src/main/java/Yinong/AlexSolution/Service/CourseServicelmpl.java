package Yinong.AlexSolution.Service;

import Yinong.AlexSolution.Controller.CSVController;
import Yinong.AlexSolution.Model.CourseModel;
import Yinong.AlexSolution.Model.Courses;
import Yinong.AlexSolution.Model.PreRequisite;
import Yinong.AlexSolution.Model.User;
import Yinong.AlexSolution.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("courseService")
public class CourseServicelmpl implements CourseService {

    @Autowired
    private  CourseRepository courseRepository;


    public List<CourseModel> getTotalCourseList() throws Exception {
        CSVController csvController = new CSVController();
        csvController.buildCourses();
        return csvController.getAllCourses();
    }

    public List<Courses> convertCourseModelToCourse(List<CourseModel> courseModels){
        List<Courses> coursesList = new ArrayList<>();
        for(CourseModel courseModel:courseModels){
            coursesList.add(new Courses(courseModel.getCourseName()));
        }
        return coursesList;
    }


    @Override
    public void mapPreRequisiteToCourses(){
        List<Courses> coursesList = this.courseRepository.findAll();


    }

    @Override
    public Optional<List<PreRequisite>> findByCourses(Courses courses){
        List<PreRequisite> preRequisiteList = new ArrayList<>();
        preRequisiteList.addAll(courses.getPreRequisites());
        Optional<List<PreRequisite>> optionalPreRequisiteList = Optional.of(preRequisiteList);
        return optionalPreRequisiteList;
    }

    @Override

    public List<User> findAllUsers(Courses courses){
        List<User> userList = new ArrayList<>();
        userList.addAll(courses.getUsers());
        Optional<List<User>> optionalUserList = Optional.of(userList);
        return optionalUserList.get();
    }
}
