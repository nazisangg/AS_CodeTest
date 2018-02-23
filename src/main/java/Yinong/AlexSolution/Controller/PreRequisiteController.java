package Yinong.AlexSolution.Controller;

import Yinong.AlexSolution.Model.PreRequisite;
import Yinong.AlexSolution.Repository.PreRequisiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/home/")
public class PreRequisiteController {
    @Autowired
    private PreRequisiteRepository preRequisiteRepository;

    @RequestMapping(value = "preRequisite", method = RequestMethod.POST)
    public PreRequisite create(@RequestBody PreRequisite preRequisite){
        return preRequisiteRepository.save(preRequisite);
    }

    @RequestMapping(value = "preRequisite/{id}", method = RequestMethod.GET)
    public PreRequisite get(@PathVariable Long id){
        return preRequisiteRepository.findOne(id);
    }

    @RequestMapping(value = "preRequisite/{id}", method = RequestMethod.DELETE)
    public PreRequisite delete(@PathVariable Long id){
        PreRequisite courses = preRequisiteRepository.findOne(id);
        preRequisiteRepository.delete(id);
        return courses;
    }

    @RequestMapping(value = "preRequisite/{id}", method = RequestMethod.PUT)
    public PreRequisite update(@PathVariable Long id, @RequestBody PreRequisite preRequisite){
        preRequisite.setId(id);
        return preRequisiteRepository.save(preRequisite);
    }
}
