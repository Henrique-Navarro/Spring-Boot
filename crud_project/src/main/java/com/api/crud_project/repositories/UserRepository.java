package com.api.crud_project.repositories;

import com.api.crud_project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT u FROM User u WHERE upper(trim(u.nome)) LIKE %?1%")
    List<User> searchByName(String name);
}
