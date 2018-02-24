package Yinong.AlexSolution.Model;

import java.util.ArrayList;
import java.util.List;

public class CourseModel {
    private String courseName;
    private List<CourseModel> prerequisite = new ArrayList();

    public CourseModel(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addElementToPreRequisite(CourseModel prerequisite) {
        this.prerequisite.add(prerequisite);
    }

    public List<CourseModel> getPrerequisite() {
        return prerequisite;
    }
}