package Yinong.AlexSolution.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private Set<User> users;

    @OneToMany(mappedBy = "courses")
    private Set<PreRequisite> preRequisites;

    public Courses(String courseName){
        this.courseName = courseName;
    }

    public Set<PreRequisite> getPreRequisites() {
        return preRequisites;
    }

    public void setPreRequisites(Set<PreRequisite> preRequisites) {
        this.preRequisites = preRequisites;
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

    public void addUsers(User user){
        this.users.add(user);
    }

    public void addPreRequisite(PreRequisite preRequisite){
        this.preRequisites.add(preRequisite);
    }
}