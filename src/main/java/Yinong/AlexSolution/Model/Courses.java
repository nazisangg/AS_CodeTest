package Yinong.AlexSolution.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Courses{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseid")
    private Long id;

    @Column(name = "courseName")
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private Set<User> users;

    @OneToMany(mappedBy = "courses")
    private Set<PreRequisite> preRequisites;

    public Courses(String courseName, Set<User> users) {
        this.courseName = courseName;
        this.users = users;
    }

    public Courses(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}