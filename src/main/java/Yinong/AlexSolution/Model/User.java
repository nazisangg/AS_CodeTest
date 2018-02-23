package Yinong.AlexSolution.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long id;

    @Column(name = "userName", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "finisedCourses",
            joinColumns = @JoinColumn(name = "user_userid", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name = "courses_courseid", referencedColumnName = "courseid")
    )
    private Set<Courses> courses;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public void addCourses(Courses course){
        this.courses.add(course);
    }
}