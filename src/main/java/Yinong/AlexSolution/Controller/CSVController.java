package Yinong.AlexSolution.Controller;

import Yinong.AlexSolution.Repository.CourseRepository;
import Yinong.AlexSolution.Repository.PreRequisiteRepository;
import Yinong.AlexSolution.Model.CourseModel;
import com.opencsv.CSVReader;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVController {
    private final String COURSEFILENAME = "/Users/yinongxia/Documents/AlexSolution_CodeTest/AlexSolution/src/main/resources/static/courses.csv";
    private final String PREREQUISITEFILENAME = "/Users/yinongxia/Documents/AlexSolution_CodeTest/AlexSolution/src/main/resources/static/prerequisites.csv";

    private CourseRepository courseRepository;

    private PreRequisiteRepository preRequisiteRepository;


    public CSVReader getReader(String CSVName) throws Exception{
        CSVReader csvReader = new CSVReader(new FileReader(CSVName), ',');
        return csvReader;
    }

    private CSVReader csvReader_Course = getReader(COURSEFILENAME);

    private CSVReader csvReader_PreRequisite= getReader(PREREQUISITEFILENAME);

    private HashMap<String, CourseModel> courses_Hash = new HashMap();

    public CSVController() throws Exception {

    }

    //

    public void buildCourses() throws IOException {
        int i = 0;
        int j = 0;
        String[] newline;
        while ((newline = this.csvReader_Course.readNext())!= null){
            if (i>0){
                String key = newline[0];
                String courseName = newline[1];
                CourseModel course = new CourseModel(courseName);
                this.courses_Hash.put(key, course);
            }
            i++;
        }

        while ((newline = this.csvReader_PreRequisite.readNext())!= null){
            if (j>0){
                String courseKey = newline[0];
                String preRequisiteKey = newline[1];
                CourseModel course = this.courses_Hash.get(courseKey);
                String preRequisiteCourseName = this.courses_Hash.get(preRequisiteKey).getCourseName();
                course.addElementToPreRequisite(preRequisiteCourseName);
                //System.out.print(courseKey+"; "+ preRequisiteCourseName+"; here\n");
            }
            j++;
        }
    }

    public HashMap<String, CourseModel> getCourses_Hash() {
        return courses_Hash;
    }

    public CSVReader getCsvReader_Course() {
        return csvReader_Course;
    }

    public void setCsvReader_Course(CSVReader csvReader_Course) {
        this.csvReader_Course = csvReader_Course;
    }

    public CSVReader getCsvReader_PreRequisite() {
        return csvReader_PreRequisite;
    }

    public void setCsvReader_PreRequisite(CSVReader csvReader_PreRequisite) {
        this.csvReader_PreRequisite = csvReader_PreRequisite;
    }
}