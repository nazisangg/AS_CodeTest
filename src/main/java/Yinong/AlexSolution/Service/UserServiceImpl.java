package Yinong.AlexSolution.Service;

import Yinong.AlexSolution.Model.User;
import Yinong.AlexSolution.Repository.CourseRepository;
import Yinong.AlexSolution.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public User findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user){

    }

    @Override
    public List<User> findByExample(User example){
        List<User> userList = new ArrayList<>();
        userList.add(example);
        return userList;
    }

    @Override
    public List<User> findBySpecification(Specification<User> specification){
        List<User> userList = new ArrayList<>();
        return userList;
    }

}
