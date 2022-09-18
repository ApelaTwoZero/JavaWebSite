package com.example.test2.Controllers;


import com.example.test2.Model.Address;
import com.example.test2.Model.Person;
import com.example.test2.repo.AddressRepository;
import com.example.test2.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public PersonRepository personRepository;

    @GetMapping("/person")
    public String Main(Model model){
        Iterable<Address> address = addressRepository.findAll();
        model.addAttribute("address",address);
        return "person";
    }

    @PostMapping("/person/add")
    public String blogPostAdd(@RequestParam String name, @RequestParam String street, Model model)
    {
        Address adress = addressRepository.findByStreet(street);
        Person person = new Person(name, adress);
        personRepository.save(person);
        return "person";
    }
}
