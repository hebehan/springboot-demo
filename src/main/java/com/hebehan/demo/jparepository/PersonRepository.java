package com.hebehan.demo.jparepository;

import com.hebehan.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long>{
}
