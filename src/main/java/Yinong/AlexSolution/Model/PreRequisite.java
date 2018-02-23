package Yinong.AlexSolution.Model;

import javax.persistence.*;

@Entity
@Table(name = "preRequisite")
public class PreRequisite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "preRequisiteid")
    private Long id;


    @Column(name = "preRequisiteCourse")
    private Long preRequisiteCourse;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courses_courseid",referencedColumnName = "courseid")
    private Courses courses;

    public PreRequisite(Long preRequisiteCourses) {
        this.preRequisiteCourse = preRequisiteCourse;
    }

    public PreRequisite(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPreRequisiteCourse() {
        return preRequisiteCourse;
    }

    public void setPreRequisiteCourse(Long preRequisiteCourse) {
        this.preRequisiteCourse = preRequisiteCourse;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}

