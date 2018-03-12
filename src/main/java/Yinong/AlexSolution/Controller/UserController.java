package Yinong.AlexSolution.Controller;

import Yinong.AlexSolution.Model.User;
import Yinong.AlexSolution.Repository.UserRepository;
import Yinong.AlexSolution.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/home")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userService")
    private UserService userService;




    @PostMapping(path = "/user")
    public @ResponseBody
    String create(@RequestBody User user){

        System.out.println("here1");
        System.out.println(user.getId());
        userRepository.save(user);
        System.out.println("here");
        return "success";
    }

    // It seem that the re quest body should be something else
    @PutMapping(value = "/user/addcourse/{courseName}")
    public User addcourse(@PathVariable String courseName, @RequestBody User user ){
        String username = user.getUsername();
        user = userRepository.findByUsername(username);
        try {
            userService.addCourse(user,courseName);
        }catch (Exception e){
        }
        return user;
    }

    @PutMapping(value = "/user/deletecourse/{courseName}")
    public User deleteCourse(@PathVariable String courseName, @RequestBody User user){
        String username = user.getUsername();
        user = userRepository.findByUsername(username);
        try{
            userService.deleteCourse(user,courseName);
        }catch (Exception e){

        }
        return user;
    }

    @RequestMapping(value = "user/{username}", method = RequestMethod.GET)
    private User get(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    @RequestMapping(value = "user/{username}", method = RequestMethod.DELETE)
    private User delete(@PathVariable String username){
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
        return user;
    }

    @RequestMapping(value = "user/{password}", method = RequestMethod.PUT)
    private User update(@PathVariable String password, @RequestBody User user){
        user.setPassword(password);
        return userRepository.save(user);
    }


}
