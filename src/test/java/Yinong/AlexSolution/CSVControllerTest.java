package Yinong.AlexSolution;

import Yinong.AlexSolution.Controller.CSVController;
import Yinong.AlexSolution.Model.CourseModel;
import com.opencsv.CSVReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CSVControllerTest {

    @Test
    public void csvcontrollertest() throws Exception{
        CSVController csvController = new CSVController();
        csvController.buildCourses();
        HashMap<String, CourseModel> courses = csvController.getCourses_Hash();
        System.out.print(courses.get("1").getCourseName()+"\n");
        System.out.print(courses.get("2").getPrerequisite().size());


    }
}
