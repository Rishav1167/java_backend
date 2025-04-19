package com.springmessagingapp.repositories;

import com.springmessagingapp.entities.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingRepository extends JpaRepository<Greetings,Long> {

}
