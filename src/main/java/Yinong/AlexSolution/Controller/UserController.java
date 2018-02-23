package Yinong.AlexSolution.Controller;

import Yinong.AlexSolution.Model.User;
import Yinong.AlexSolution.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/home/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    private User create(@RequestBody User user){
        return userRepository.save(user);

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
