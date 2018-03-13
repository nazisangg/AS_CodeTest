package Yinong.AlexSolution.Controller;

import Yinong.AlexSolution.Model.Courses;
import Yinong.AlexSolution.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

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
}
