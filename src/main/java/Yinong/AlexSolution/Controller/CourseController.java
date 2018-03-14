package Yinong.AlexSolution.Controller;

import Yinong.AlexSolution.Model.APIResponse;
import Yinong.AlexSolution.Model.Courses;
import Yinong.AlexSolution.Repository.CourseRepository;
import Yinong.AlexSolution.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homes")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public Courses create(@RequestBody Courses courses){
        return courseRepository.save(courses);
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Courses get(@PathVariable Long id){
        return courseRepository.findOne(id);
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public Courses delete(@PathVariable Long id){
        Courses courses = courseRepository.findOne(id);
        courseRepository.delete(id);
        return courses;
    }

    @RequestMapping(value = "/course/{coursename}", method = RequestMethod.PUT)
    public Courses update(@PathVariable String coursename, @RequestBody Courses courses){
        courses.setCourseName(coursename);
        return courseRepository.save(courses);
    }

    @RequestMapping(value = "/course/getAll",method = RequestMethod.GET)
    public APIResponse getAllCourses(){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setErrorCode("N/A");
        apiResponse.setErrorMessage("N/A");
        apiResponse.setSuccess(true);
        apiResponse.setResponseObject(courseRepository.findAll());
        return apiResponse;
    }

    @RequestMapping(value = "/course/getAllUsers/{id}",method = RequestMethod.GET)
    public APIResponse getAllUsers(@PathVariable Long id){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setErrorCode("N/A");
        apiResponse.setErrorMessage("N/A");
        apiResponse.setSuccess(true);
        Courses courses = courseRepository.findById(id);
        apiResponse.setResponseObject(courseService.findAllUsers(courses));
        return apiResponse;
    }
}
