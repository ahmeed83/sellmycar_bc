package com.focustechnology.sellmycar.user.repository;

import com.focustechnology.sellmycar.user.repository.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    Optional<Person> findByLoginsEmailAndLoginsActiveTrue(String email);
}
