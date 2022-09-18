package com.example.test2.repo;

import com.example.test2.Model.People;
import com.example.test2.Model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Long> {
}
