package Yinong.AlexSolution.Model;

import java.util.ArrayList;
import java.util.List;

public class CourseModel {
    private String courseName;
    private List<String> prerequisite = new ArrayList();

    public CourseModel(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addElementToPreRequisite(String prerequisite) {
        this.prerequisite.add(prerequisite);
    }

    public List<String> getPrerequisite() {
        return prerequisite;
    }
}