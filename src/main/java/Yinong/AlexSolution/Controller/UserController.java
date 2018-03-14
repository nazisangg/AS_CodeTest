package Yinong.AlexSolution.Controller;

import Yinong.AlexSolution.Model.APIResponse;
import Yinong.AlexSolution.Model.User;
import Yinong.AlexSolution.Repository.UserRepository;
import Yinong.AlexSolution.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/homes")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userService")
    private UserService userService;




    @PostMapping(path = "/users")
    public @ResponseBody
    String create(@RequestBody User user){

        System.out.println("here1");
        System.out.println(user.getId());
        userRepository.save(user);
        System.out.println("here");
        return "success";
    }

    // It seem that the re quest body should be something else
    @PutMapping(value = "/users/addcourse/{courseName}")
    public User addcourse(@PathVariable String courseName, @RequestBody User user ){
        String username = user.getUsername();
        user = userRepository.findByUsername(username);
        try {
            userService.addCourse(user,courseName);
        }catch (Exception e){
        }

        return userRepository.save(user);
    }

    @PutMapping(value = "/users/deletecourse/{courseName}")
    public User deleteCourse(@PathVariable String courseName, @RequestBody User user){
        String username = user.getUsername();
        user = userRepository.findByUsername(username);
        try{
            userService.deleteCourse(user,courseName);
        }catch (Exception e){

        }
        return userRepository.save(user);
    }

    @RequestMapping(value = "users/{username}", method = RequestMethod.GET)
    private User get(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    @RequestMapping(value = "users/getbyid/{id}", method = RequestMethod.GET)
    private User getById(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @RequestMapping(value = "users/{username}", method = RequestMethod.DELETE)
    private User delete(@PathVariable String username){
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
        return user;
    }

    @RequestMapping(value = "users/{password}", method = RequestMethod.PUT)
    private User update(@PathVariable String password, @RequestBody User user){
        user.setPassword(password);
        return userRepository.save(user);
    }

    @RequestMapping(value = "users/getAll", method = RequestMethod.GET )
    public APIResponse getAllUsers(){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setErrorCode("N/A");
        apiResponse.setErrorMessage("N/A");
        apiResponse.setSuccess(true);
        apiResponse.setResponseObject(userRepository.findAll());
        return apiResponse;
    }


}
