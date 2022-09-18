package com.example.test2.repo;

import com.example.test2.Model.Pasport;
import org.springframework.data.repository.CrudRepository;

public interface PasportRepository extends CrudRepository<Pasport, Long> {
    Pasport findByNumber(String number);
}
