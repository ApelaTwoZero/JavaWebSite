package com.example.test2.Controllers;


import com.example.test2.Model.Pasport;
import com.example.test2.Model.People;
import com.example.test2.repo.PasportRepository;
import com.example.test2.repo.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OnetoOne {
    @Autowired
    private PasportRepository pasportRepository;
    @Autowired
    private PeopleRepository peopleRepository;



    @GetMapping("/peoples")
    public String Main(Model model){
        Iterable<Pasport> pasport = pasportRepository.findAll();
        model.addAttribute("pasport", pasport);
        return "peoples";
    }

    @PostMapping("/peoples/add")
    public String blogPostAdd(@RequestParam String name, @RequestParam String number, Model model)
    {
        System.out.println(name);
        Pasport pasport = pasportRepository.findByNumber(number);
        System.out.println(pasport.getId());
        People people = new People(name, pasport);
        peopleRepository.save(people);
        return "peoples";
    }
}
