package Yinong.AlexSolution;

import Yinong.AlexSolution.Controller.CSVController;
import Yinong.AlexSolution.Controller.SearchController;
import Yinong.AlexSolution.Model.CourseModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchControllerTest {
    @Test
    public void csvcontrollertest() throws Exception{
        CSVController csvController = new CSVController();
        csvController.buildCourses();
        List<CourseModel> courseList = csvController.getAllCourses();
        // check if the course list is correct
        Assert.assertEquals(12, courseList.size());
        List<CourseModel> DoneList = new ArrayList<>();
        List<CourseModel> tagetList = new ArrayList<>();
        DoneList.add(courseList.get(2));
        DoneList.add(courseList.get(5));
        DoneList.add(courseList.get(8));
        SearchController searchController = new SearchController(DoneList,tagetList,courseList);
        HashMap<Integer,List<CourseModel>> courseOrder = searchController.findAllCourseOrder();
        System.out.print(courseOrder.size()+"\n");
        for(Integer i = 0; i < courseOrder.size(); i++ ){
            for(CourseModel course: courseOrder.get(i)){
                System.out.print("Level " + i + " " + course.getCourseName() + "\n");
            }
        }


    }
}
