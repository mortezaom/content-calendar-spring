package dev.mortezaom.eventcalendar.repository;

import dev.mortezaom.eventcalendar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}